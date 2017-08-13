package thesis.eng.reviewer.fragment.presenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.ExamResultTable;
import thesis.eng.reviewer.dao.QuestionaireTable;
import thesis.eng.reviewer.dao.QuestionaireTableDao;
import thesis.eng.reviewer.dao.SubCategoryTable;
import thesis.eng.reviewer.dao.SubCategoryTableDao;
import thesis.eng.reviewer.dao.TakenLogTableDao;
import thesis.eng.reviewer.fragment.ExamFinishFragment;
import thesis.eng.reviewer.fragment.QuestionExamFragment;
import thesis.eng.reviewer.fragment.QuestionFragment;
import thesis.eng.reviewer.fragment.contract.ExamContract;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public final class ExamPresenter  implements ExamContract.Presenter {
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final SubCategoryTableDao subCategoryTableDao= daoSession.getSubCategoryTableDao();
    private final QuestionaireTableDao questionaireTableDao= daoSession.getQuestionaireTableDao();
    private final TakenLogTableDao takenLogTableDao= daoSession.getTakenLogTableDao();
    @Override
    public Long getSubcategoryCount(Long id) {
        return subCategoryTableDao.queryBuilder().where(SubCategoryTableDao.Properties.CatId.eq(id)).count();
    }

    @Override
    public List<QuestionaireTable> loadQuestion(Long catID) {
        Random rand = new Random();
        byte order= (byte) (rand.nextInt(6) + 1);
        Long subcatCount =getSubcategoryCount(catID);
        int  itemsPerSubCategory= (int) (240/subcatCount);
        List<QuestionaireTable> quizTableList = new ArrayList<>();
        int x =1;
        Log.e("coutn", String.valueOf(itemsPerSubCategory));
        for (SubCategoryTable subcat: getSubcategoryList(catID)){
            for(QuestionaireTable questionaireTable:questionaireTableDao.queryBuilder().where(QuestionaireTableDao.Properties.CategoryID.eq(catID),
                    QuestionaireTableDao.Properties.SubCategory.eq(subcat.getSubcategoryname())) .orderAsc(
                    order==1? QuestionaireTableDao.Properties.Answer:
                            order==2? QuestionaireTableDao.Properties.CategoryID:
                                    order==3?QuestionaireTableDao.Properties.Category:
                                            order==4?QuestionaireTableDao.Properties.Id:
                                                    order==5?QuestionaireTableDao.Properties.Option1:
                                                            order==6?QuestionaireTableDao.Properties.Option2:
                                                                    QuestionaireTableDao.Properties.Option3
            ).limit(x==subcatCount? (int) ((240 - (itemsPerSubCategory * subcatCount)) + itemsPerSubCategory) :itemsPerSubCategory).list()){
                Log.e("exa",questionaireTable.getOption1());
                quizTableList.add(questionaireTable);
            } Log.e("exa",subcat.getSubcategoryname());

            x++;
        }

        return quizTableList;
    }

    @Override
    public List<SubCategoryTable> getSubcategoryList(Long caID) {
        return subCategoryTableDao.queryBuilder().where(SubCategoryTableDao.Properties.CatId.eq(caID)).list();
    }
   @Override
    public int getTotalQuestionCount(Long catID) {
       int total=0;
        Long subcatCount =getSubcategoryCount(catID);
        int  itemsPerSubCategory= (int) (240/subcatCount);
        int x =1;
        for (SubCategoryTable subcat: getSubcategoryList(catID)) {
            for (QuestionaireTable questionaireTable : questionaireTableDao.queryBuilder().where(QuestionaireTableDao.Properties.CategoryID.eq(catID),
                    QuestionaireTableDao.Properties.SubCategory.eq(subcat.getSubcategoryname())).limit(x == subcatCount ? (int) ((240 - (itemsPerSubCategory * subcatCount)) + itemsPerSubCategory) : itemsPerSubCategory).list()) {
                total = total + 1;
            }
            x++;

        }

        return total;
    }

    @Override
    public Fragment getExamFinishFragment(List<ExamResultTable> examResultTableList) {
        ExamFinishFragment examFinishFragment = new ExamFinishFragment();
        examFinishFragment.setAnswersObject(examResultTableList);
        return examFinishFragment;

    }

    @Override
    public void shuffleOption(ExamResultTable examResultTable, Byte order, QuestionFragment questionFragment, QuestionaireTable q) {
        if(order==1){
            examResultTable.setOption1(q.getAnswer());
            examResultTable.setOption2(q.getOption1());
            examResultTable.setOption3(q.getOption2());
            examResultTable.setOption4(q.getOption3());

            questionFragment.setOption1(q.getAnswer());
            questionFragment.setOption2(q.getOption1());
            questionFragment.setOption3(q.getOption2());
            questionFragment.setOption4(q.getOption3());
        }else if(order==2){
            examResultTable.setOption2(q.getAnswer());
            examResultTable.setOption1(q.getOption1());
            examResultTable.setOption3(q.getOption2());
            examResultTable.setOption4(q.getOption3());

            questionFragment.setOption2(q.getAnswer());
            questionFragment.setOption1(q.getOption1());
            questionFragment.setOption3(q.getOption2());
            questionFragment.setOption4(q.getOption3());
        }else if(order==3){
            examResultTable.setOption2(q.getAnswer());
            examResultTable.setOption3(q.getOption1());
            examResultTable.setOption1(q.getOption2());
            examResultTable.setOption4(q.getOption3());

            questionFragment.setOption2(q.getAnswer());
            questionFragment.setOption3(q.getOption1());
            questionFragment.setOption1(q.getOption2());
            questionFragment.setOption4(q.getOption3());
        }else if(order==4){
            examResultTable.setOption4(q.getAnswer());
            examResultTable.setOption3(q.getOption1());
            examResultTable.setOption2(q.getOption2());
            examResultTable.setOption1(q.getOption3());

            questionFragment.setOption4(q.getAnswer());
            questionFragment.setOption3(q.getOption1());
            questionFragment.setOption2(q.getOption2());
            questionFragment.setOption1(q.getOption3());
        }else if(order==5){
            examResultTable.setOption3(q.getAnswer());
            examResultTable.setOption4(q.getOption1());
            examResultTable.setOption2(q.getOption2());
            examResultTable.setOption1(q.getOption3());

            questionFragment.setOption3(q.getAnswer());
            questionFragment.setOption4(q.getOption1());
            questionFragment.setOption2(q.getOption2());
            questionFragment.setOption1(q.getOption3());
        }else if(order==6){
            examResultTable.setOption2(q.getAnswer());
            examResultTable.setOption4(q.getOption1());
            examResultTable.setOption3(q.getOption2());
            examResultTable.setOption1(q.getOption3());

            questionFragment.setOption2(q.getAnswer());
            questionFragment.setOption4(q.getOption1());
            questionFragment.setOption3(q.getOption2());
            questionFragment.setOption1(q.getOption3());
        }else if(order==7){
            examResultTable.setOption3(q.getAnswer());
            examResultTable.setOption4(q.getOption1());
            examResultTable.setOption2(q.getOption2());
            examResultTable.setOption1(q.getOption3());

            questionFragment.setOption3(q.getAnswer());
            questionFragment.setOption4(q.getOption1());
            questionFragment.setOption2(q.getOption2());
            questionFragment.setOption1(q.getOption3());
        }

    }


    @NonNull
    @Override
    public Long getTakenActivityCount() {
        return takenLogTableDao.queryBuilder() .count();
    }

    @Override
    public void setQuestionaireTable(Long totalLogs, QuestionaireTable q, List<ExamResultTable> examResultTable) {
        ExamResultTable reviewQuizTable = new ExamResultTable();
        reviewQuizTable.setForeignKey(totalLogs);
        reviewQuizTable.setPoints((long) q.getPoints());
        reviewQuizTable.setYourAnswer("");
        reviewQuizTable.setCategory(q.getCategory());
        reviewQuizTable.setCategoryID(q.getCategoryID());
        reviewQuizTable.setCorrectAnswer(q.getAnswer());
        reviewQuizTable.setQuestion(q.getQuestion());
        reviewQuizTable.setSubCategory(q.getSubCategory());
        reviewQuizTable.setSubCategoryID(q.getSubCategoryID());
        examResultTable.add(reviewQuizTable);

    }

    @Override
    public QuestionExamFragment getQuestionFragment(QuestionaireTable q, int x, List<ExamResultTable> examResultTable, Long total) {
        QuestionExamFragment questionFragment= new QuestionExamFragment();
        questionFragment.setQuestionNumber(x+1);
        questionFragment.setQuestion(q.getQuestion());
        questionFragment.setTotal(total);
        questionFragment.setQuestionPoints(String.valueOf(q.getPoints()));
        questionFragment.setExamResultTable(examResultTable.get(x));
        return questionFragment; }


}
