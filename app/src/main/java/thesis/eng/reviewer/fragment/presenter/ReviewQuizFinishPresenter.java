package thesis.eng.reviewer.fragment.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.dao.ReviewQuizTableDao;
import thesis.eng.reviewer.dao.TakenLogTable;
import thesis.eng.reviewer.dao.TakenLogTableDao;
import thesis.eng.reviewer.fragment.contract.ReviewQuizFinishContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public final class ReviewQuizFinishPresenter implements ReviewQuizFinishContract.Presenter {
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final ReviewQuizTableDao reviewQuizTableDao= daoSession.getReviewQuizTableDao();
    private final TakenLogTableDao takenLogTableDao= daoSession.getTakenLogTableDao();
    private ReviewQuizFinishContract.View view;
    public ReviewQuizFinishPresenter(ReviewQuizFinishContract.View view){
        this.view=view;
    }
    @Override
    public void insertQuizRecord(ReviewQuizTable reviewQuizTable) {
            reviewQuizTableDao.insert(reviewQuizTable);

       }

    @Override
    public void insertTakenLog(List<ReviewQuizTable> reviewQuizTables) {
        TakenLogTable table = new TakenLogTable();
        table.setCategory(reviewQuizTables.get(0).getCategory());
        table.setSubcategory(reviewQuizTables.get(0).getSubCategory());
        table.setType("PRACTICE_REVIEW");
        table.setDateTaken(DateFormat.getDateTimeInstance().format(new Date()));
        table.setOverAllPoints(getTotalPoints(reviewQuizTables));
        table.setYourPoints(computeScore(reviewQuizTables));
        table.setUsername("james");
        takenLogTableDao.insert(table);
    }

    @Override
    public void submitActivity(List<ReviewQuizTable> answersObject) {
        Database database = MyApplication.getInstance().getDaoSession().getDatabase();
        database.beginTransaction();
        try {
            insertTakenLog(answersObject);
            for(ReviewQuizTable reviewQuizTable : answersObject)
                insertQuizRecord(reviewQuizTable);
            database.setTransactionSuccessful();
            Log.i("success","inserting");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            database.endTransaction();
            view.gotoActivityTakenFragment();
        }
    }

    @NonNull
    @Override
    public Long computeScore(List<ReviewQuizTable> reviewQuizTableList) {
        long total=0;
        for (ReviewQuizTable reviewQuizTable:reviewQuizTableList){
            if(reviewQuizTable.getCorrectAnswer().equals(reviewQuizTable.getYourAnswer()))
                total=total+reviewQuizTable.getPoints();
        }
        return total;
    }

    @NonNull
    @Override
    public Long getTotalPoints(List<ReviewQuizTable> reviewQuizTables) {
        long totalPoints =0;
        for (ReviewQuizTable reviewQuizTable : reviewQuizTables)
            totalPoints=totalPoints+reviewQuizTable.getPoints();
        return totalPoints;
    }
}
