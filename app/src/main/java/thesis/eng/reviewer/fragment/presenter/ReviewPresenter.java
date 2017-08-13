package thesis.eng.reviewer.fragment.presenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.Random;

import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.QuestionaireTable;
import thesis.eng.reviewer.dao.QuestionaireTableDao;
import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.dao.TakenLogTableDao;
import thesis.eng.reviewer.fragment.QuestionFragment;
import thesis.eng.reviewer.fragment.ReviewQuizFinishFragment;
import thesis.eng.reviewer.fragment.contract.ReviewContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public class ReviewPresenter implements ReviewContract.Presenter {
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final QuestionaireTableDao questionaireTableDao= daoSession.getQuestionaireTableDao();
    private final TakenLogTableDao takenLogTableDao= daoSession.getTakenLogTableDao();
    @Override
    public List<QuestionaireTable> loadQuestion(long subcatID, long catID, String catIDName, String subcatName) {
        Random rand = new Random();
        byte order= (byte) (rand.nextInt(8) + 1);
        return questionaireTableDao.queryBuilder()
                .where(QuestionaireTableDao.Properties.CategoryID.eq(catID), QuestionaireTableDao.Properties.SubCategoryID.eq(subcatID))
                .orderAsc(
                        order==1? QuestionaireTableDao.Properties.Answer:
                                order==2? QuestionaireTableDao.Properties.CategoryID:
                                        order==3?QuestionaireTableDao.Properties.Category:
                                                order==4?QuestionaireTableDao.Properties.Id:
                                                        order==5?QuestionaireTableDao.Properties.Option1:
                                                                order==6?QuestionaireTableDao.Properties.Option2:
                                                                        order==7?QuestionaireTableDao.Properties.Option3:
                                                                                order==8?QuestionaireTableDao.Properties.SubCategory:
                                                                                        QuestionaireTableDao.Properties.SubCategoryID
                ).list();


    }

    @NonNull
    @Override
    public Long getQuestionCount(long subcatID, long catID) {
        return questionaireTableDao.queryBuilder() .where(QuestionaireTableDao.Properties.CategoryID.eq(catID), QuestionaireTableDao.Properties.SubCategoryID.eq(subcatID)).count();
    }

    @NonNull
    @Override
    public Long getTakenActivityCount() {
        return takenLogTableDao.queryBuilder() .count();
    }

    @Override
    public void setQuestionaireTable(Long totalLogs, QuestionaireTable q, List<ReviewQuizTable> reviewQuizTableList) {
        ReviewQuizTable reviewQuizTable = new ReviewQuizTable();
        reviewQuizTable.setForeignKey(totalLogs);
        reviewQuizTable.setPoints((long) q.getPoints());
        reviewQuizTable.setYourAnswer("");
        reviewQuizTable.setCategory(q.getCategory());
        reviewQuizTable.setCategoryID(q.getCategoryID());
        reviewQuizTable.setCorrectAnswer(q.getAnswer());
        reviewQuizTable.setQuestion(q.getQuestion());
        reviewQuizTable.setSubCategory(q.getSubCategory());
        reviewQuizTable.setSubCategoryID(q.getSubCategoryID());
        reviewQuizTableList.add(reviewQuizTable);

    }

    @Override
    public QuestionFragment getQuestionFragment(ViewPager pager,QuestionaireTable q, int x, List<ReviewQuizTable> reviewQuizTableList, Long total) {
        QuestionFragment questionFragment= new QuestionFragment();
        questionFragment.setQuestionNumber(x+1);
        questionFragment.setQuestion(q.getQuestion());
        questionFragment.setTotal(total);
        questionFragment.setQuestionPoints(String.valueOf(q.getPoints()));
        questionFragment.setReviewObject(reviewQuizTableList.get(x));
        questionFragment.setViewPager(pager);
        return questionFragment;
    }

    @Override
    public Fragment getReviewQuizFinishFragment(List<ReviewQuizTable> reviewQuizTableList) {
        ReviewQuizFinishFragment reviewQuizFinishFragment = new ReviewQuizFinishFragment();
        reviewQuizFinishFragment.setAnswersObject(reviewQuizTableList);
        return reviewQuizFinishFragment;
    }


    @Override
    public void shuffleOption(ReviewQuizTable reviewQuizTable, Byte order, QuestionFragment questionFragment, QuestionaireTable q) {
        if(order==1){
            reviewQuizTable.setOption1(q.getAnswer());
            reviewQuizTable.setOption2(q.getOption1());
            reviewQuizTable.setOption3(q.getOption2());
            reviewQuizTable.setOption4(q.getOption3());

            questionFragment.setOption1(q.getAnswer());
            questionFragment.setOption2(q.getOption1());
            questionFragment.setOption3(q.getOption2());
            questionFragment.setOption4(q.getOption3());
        }else if(order==2){
            reviewQuizTable.setOption2(q.getAnswer());
            reviewQuizTable.setOption1(q.getOption1());
            reviewQuizTable.setOption3(q.getOption2());
            reviewQuizTable.setOption4(q.getOption3());

            questionFragment.setOption2(q.getAnswer());
            questionFragment.setOption1(q.getOption1());
            questionFragment.setOption3(q.getOption2());
            questionFragment.setOption4(q.getOption3());
        }else if(order==3){
            reviewQuizTable.setOption2(q.getAnswer());
            reviewQuizTable.setOption3(q.getOption1());
            reviewQuizTable.setOption1(q.getOption2());
            reviewQuizTable.setOption4(q.getOption3());

            questionFragment.setOption2(q.getAnswer());
            questionFragment.setOption3(q.getOption1());
            questionFragment.setOption1(q.getOption2());
            questionFragment.setOption4(q.getOption3());
        }else if(order==4){
            reviewQuizTable.setOption4(q.getAnswer());
            reviewQuizTable.setOption3(q.getOption1());
            reviewQuizTable.setOption2(q.getOption2());
            reviewQuizTable.setOption1(q.getOption3());

            questionFragment.setOption4(q.getAnswer());
            questionFragment.setOption3(q.getOption1());
            questionFragment.setOption2(q.getOption2());
            questionFragment.setOption1(q.getOption3());
        }else if(order==5){
            reviewQuizTable.setOption3(q.getAnswer());
            reviewQuizTable.setOption4(q.getOption1());
            reviewQuizTable.setOption2(q.getOption2());
            reviewQuizTable.setOption1(q.getOption3());

            questionFragment.setOption3(q.getAnswer());
            questionFragment.setOption4(q.getOption1());
            questionFragment.setOption2(q.getOption2());
            questionFragment.setOption1(q.getOption3());
        }else if(order==6){
            reviewQuizTable.setOption2(q.getAnswer());
            reviewQuizTable.setOption4(q.getOption1());
            reviewQuizTable.setOption3(q.getOption2());
            reviewQuizTable.setOption1(q.getOption3());

            questionFragment.setOption2(q.getAnswer());
            questionFragment.setOption4(q.getOption1());
            questionFragment.setOption3(q.getOption2());
            questionFragment.setOption1(q.getOption3());
        }else if(order==7){
            reviewQuizTable.setOption3(q.getAnswer());
            reviewQuizTable.setOption4(q.getOption1());
            reviewQuizTable.setOption2(q.getOption2());
            reviewQuizTable.setOption1(q.getOption3());

            questionFragment.setOption3(q.getAnswer());
            questionFragment.setOption4(q.getOption1());
            questionFragment.setOption2(q.getOption2());
            questionFragment.setOption1(q.getOption3());
        }

    }


}
