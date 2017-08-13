package thesis.eng.reviewer.fragment.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.ExamResultTable;
import thesis.eng.reviewer.dao.ExamResultTableDao;
import thesis.eng.reviewer.dao.SessionManagerDao;
import thesis.eng.reviewer.dao.TakenLogTable;
import thesis.eng.reviewer.dao.TakenLogTableDao;
import thesis.eng.reviewer.fragment.contract.ExamFinishContract;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public final class ExamFinishPresenter implements ExamFinishContract.Presenter {
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final ExamResultTableDao examResultTableDao= daoSession.getExamResultTableDao();
    private final TakenLogTableDao takenLogTableDao= daoSession.getTakenLogTableDao();
    private final SessionManagerDao sessionManager= daoSession.getSessionManagerDao();
    private ExamFinishContract.View view;
    public ExamFinishPresenter(ExamFinishContract.View view){
        this.view=view;
    }
    @Override
    public void insertQuizRecord(ExamResultTable examResultTable) {
        examResultTableDao.insert(examResultTable);

    }

    @Override
    public void insertTakenLog(List<ExamResultTable> reviewQuizTables) {
        TakenLogTable table = new TakenLogTable();
        table.setCategory(reviewQuizTables.get(0).getCategory());
        table.setSubcategory(reviewQuizTables.get(0).getSubCategory());
        table.setType("EXAM");
        table.setDateTaken( DateFormat.getDateTimeInstance().format(new Date()));
        table.setOverAllPoints(getTotalPoints(reviewQuizTables));
        table.setYourPoints(computeScore(reviewQuizTables));
        table.setUsername(sessionManager.queryBuilder().orderDesc(SessionManagerDao.Properties.Id).limit(1).unique().getUsername());
        takenLogTableDao.insert(table);
    }

    @Override
    public void submitActivity(List<ExamResultTable> answersObject) {
        Database database = MyApplication.getInstance().getDaoSession().getDatabase();
        database.beginTransaction();
        try {
            insertTakenLog(answersObject);
            for(ExamResultTable reviewQuizTable : answersObject)
                insertQuizRecord(reviewQuizTable);
            database.setTransactionSuccessful();
            Log.i("success","insertingexam");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            database.endTransaction();
            view.gotoActivityTakenFragment();
        }
    }

    @NonNull
    @Override
    public Long computeScore(List<ExamResultTable> reviewQuizTableList) {
        long total=0;
        for (ExamResultTable reviewQuizTable:reviewQuizTableList){
            if(reviewQuizTable.getCorrectAnswer().equals(reviewQuizTable.getYourAnswer()))
                total=total+reviewQuizTable.getPoints();
        }
        return total;
    }

    @NonNull
    @Override
    public Long getTotalPoints(List<ExamResultTable> reviewQuizTables) {
        long totalPoints =0;
        for (ExamResultTable reviewQuizTable : reviewQuizTables)
            totalPoints=totalPoints+reviewQuizTable.getPoints();
        return totalPoints;
    }
}
