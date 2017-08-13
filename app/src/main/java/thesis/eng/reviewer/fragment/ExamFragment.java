package thesis.eng.reviewer.fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.greendao.database.Database;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.ExamResultTable;
import thesis.eng.reviewer.dao.ExamResultTableDao;
import thesis.eng.reviewer.dao.QuestionaireTable;
import thesis.eng.reviewer.dao.SessionManagerDao;
import thesis.eng.reviewer.dao.SessionTimer;
import thesis.eng.reviewer.dao.SessionTimerDao;
import thesis.eng.reviewer.dao.TakenLogTable;
import thesis.eng.reviewer.dao.TakenLogTableDao;
import thesis.eng.reviewer.fragment.presenter.ExamPresenter;
import thesis.eng.reviewer.fragment.view.ReviewView;
import thesis.eng.reviewer.helper.FragmentChange;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public class ExamFragment extends ReviewView {
    private Long catID;
    private String catName;
    private ExamPresenter presenter;
    List<ExamResultTable> reviewQuizTableList = new ArrayList<>();
    private String type;

    @Override
    protected void initPages() {
        addPage("Introduction",getQuizFrontFragment(catName,""));
        int x=0;
        Random rand = new Random();
        int totalpages=presenter.getTotalQuestionCount(catID);
        for(QuestionaireTable q:presenter.loadQuestion(catID)){
            presenter.setQuestionaireTable(presenter.getTakenActivityCount()+1,q,reviewQuizTableList);
            QuestionExamFragment questionFragment = presenter.getQuestionFragment(q,x,reviewQuizTableList, (long) totalpages);
            presenter.shuffleOption(reviewQuizTableList.get(x),(byte) (rand.nextInt(7) + 1),questionFragment,q);
            addPage("Q-"+(x+1),questionFragment);
            x++;
        }
        addPage("Complete",presenter.getExamFinishFragment(reviewQuizTableList));

    }
    @Override
    protected void initComponents() {
        presenter= new ExamPresenter();
    }
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final SessionTimerDao sessionTimerDao= daoSession.getSessionTimerDao();
    private final TakenLogTableDao takenLogTableDao= daoSession.getTakenLogTableDao();
    private final ExamResultTableDao examResultTableDao= daoSession.getExamResultTableDao();
    private final SessionManagerDao sessionManagerDao= daoSession.getSessionManagerDao();

    private CountDownTimer countDownTimer;
    @Override
    protected void initServices() {
        hideDrawer();
        if(type.equals("TIMED")){
            SessionTimer sessionTimer= sessionTimerDao.queryBuilder().where(SessionTimerDao.Properties.Type.eq(type)).orderDesc(SessionTimerDao.Properties.Id).unique();
            countDownTimer=new CountDownTimer(Long.parseLong(sessionTimer.getTime()+"000"), 1000) {
                public void onTick(long millisUntilFinished) {
                    ((TextView)getActivity().findViewById(R.id.titletoolbar)).setText("Examination (Time: "+Long.parseLong(String.valueOf(millisUntilFinished/1000))+")");
                }
                public void onFinish() {
                    Database database = MyApplication.getInstance().getDaoSession().getDatabase();
                    database.beginTransaction();
                    try {
                              insertTakenLog(reviewQuizTableList);
                        for(ExamResultTable reviewQuizTable : reviewQuizTableList)
                            insertQuizRecord(reviewQuizTable);
                        database.setTransactionSuccessful();
                        Log.i("success","insertingexam");
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        database.endTransaction();
                        FragmentChange.load(R.id.fragmentContainer,getFragmentManager(),new TakenLogFragment());
                    }
                }
            }.start();

        }

    }

    private void insertQuizRecord(ExamResultTable examResultTable) {
        examResultTableDao.insert(examResultTable);

    }

    private void insertTakenLog(List<ExamResultTable> reviewQuizTables) {
        TakenLogTable table = new TakenLogTable();
        table.setCategory(reviewQuizTables.get(0).getCategory());
        table.setSubcategory(reviewQuizTables.get(0).getSubCategory());
        table.setType("EXAM");
        table.setDateTaken( DateFormat.getDateTimeInstance().format(new Date()));
        table.setOverAllPoints(getTotalPoints(reviewQuizTables));
        table.setYourPoints(computeScore(reviewQuizTables));
        table.setUsername(sessionManagerDao.queryBuilder().orderDesc(SessionManagerDao.Properties.Id).limit(1).unique().getUsername());
        takenLogTableDao.insert(table);

    }

    private Long computeScore(List<ExamResultTable> reviewQuizTables) {
        long total=0;
        for (ExamResultTable reviewQuizTable:reviewQuizTables){
            if(reviewQuizTable.getCorrectAnswer().equals(reviewQuizTable.getYourAnswer()))
                total=total+reviewQuizTable.getPoints();
        }
        return total;
    }

    private Long getTotalPoints(List<ExamResultTable> reviewQuizTables) {
        long totalPoints =0;
        for (ExamResultTable reviewQuizTable : reviewQuizTables)
            totalPoints=totalPoints+reviewQuizTable.getPoints();
        return totalPoints;
    }

    public void setCatID(Long catID) {
        this.catID = catID;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public void onDestroyView() {
        countDownTimer.cancel();
        super.onDestroyView();
    }

    public void setType(String type) {
        this.type = type;
    }
}
