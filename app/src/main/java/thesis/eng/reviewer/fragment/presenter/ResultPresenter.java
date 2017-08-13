package thesis.eng.reviewer.fragment.presenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.util.List;

import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.ExamResultTable;
import thesis.eng.reviewer.dao.ExamResultTableDao;
import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.dao.ReviewQuizTableDao;
import thesis.eng.reviewer.fragment.ResultLogFragment;
import thesis.eng.reviewer.fragment.contract.ResultContract;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public final class ResultPresenter implements ResultContract.Presenter {
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final ReviewQuizTableDao reviewQuizTableDao= daoSession.getReviewQuizTableDao();
    private final ExamResultTableDao examResultTable= daoSession.getExamResultTableDao();

    @Override
    public List<ReviewQuizTable> getActivityTaken(Long id) {
        return reviewQuizTableDao.queryBuilder().where(ReviewQuizTableDao.Properties.ForeignKey.eq(id)).list();
    }

    @Override
    public Fragment getResultLogFragment(int x, ReviewQuizTable reviewQuizTable, Long questionCount) {
        ResultLogFragment resultLogFragment = new ResultLogFragment();
        resultLogFragment.setQuestionPoints(String.valueOf(reviewQuizTable.getPoints()));
        resultLogFragment.setQuestion(reviewQuizTable.getQuestion());
        resultLogFragment.setOption1(reviewQuizTable.getOption1());
        resultLogFragment.setOption2(reviewQuizTable.getOption2());
        resultLogFragment.setOption3(reviewQuizTable.getOption3());
        resultLogFragment.setOption4(reviewQuizTable.getOption4());
        resultLogFragment.setQuestionNumber(String.valueOf(x));
        resultLogFragment.setCorrectAnswer(reviewQuizTable.getCorrectAnswer());
        resultLogFragment.setYourAnswer(reviewQuizTable.getYourAnswer());
        resultLogFragment.setTotal(questionCount);
        return resultLogFragment;
    }

    @NonNull
    @Override
    public Long getQuestionCount(Long id) {
        return reviewQuizTableDao.queryBuilder() .where(ReviewQuizTableDao.Properties.ForeignKey.eq(id)).count();

    }

    @Override
    public Long getQuestionExamCount(Long id) {
        return examResultTable.queryBuilder() .where(ExamResultTableDao.Properties.ForeignKey.eq(id)).count();


    }

    @Override
    public List<ExamResultTable> getExamTaken(Long id) {
        return examResultTable.queryBuilder().where(ExamResultTableDao.Properties.ForeignKey.eq(id)).list();
    }

    @Override
    public Fragment getResultExamLogFragment(int x, ExamResultTable reviewQuizTable, Long questionCount) {
        ResultLogFragment resultLogFragment = new ResultLogFragment();
        resultLogFragment.setQuestionPoints(String.valueOf(reviewQuizTable.getPoints()));
        resultLogFragment.setQuestion(reviewQuizTable.getQuestion());
        resultLogFragment.setOption1(reviewQuizTable.getOption1());
        resultLogFragment.setOption2(reviewQuizTable.getOption2());
        resultLogFragment.setOption3(reviewQuizTable.getOption3());
        resultLogFragment.setOption4(reviewQuizTable.getOption4());
        resultLogFragment.setQuestionNumber(String.valueOf(x));
        resultLogFragment.setCorrectAnswer(reviewQuizTable.getCorrectAnswer());
        resultLogFragment.setYourAnswer(reviewQuizTable.getYourAnswer());
        resultLogFragment.setTotal(questionCount);
        return resultLogFragment;
    }
}
