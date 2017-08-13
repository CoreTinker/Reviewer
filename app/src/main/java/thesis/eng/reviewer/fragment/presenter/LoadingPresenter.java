package thesis.eng.reviewer.fragment.presenter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.CategoryTable;
import thesis.eng.reviewer.dao.CategoryTableDao;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.QuestionaireTable;
import thesis.eng.reviewer.dao.QuestionaireTableDao;
import thesis.eng.reviewer.dao.SessionTimer;
import thesis.eng.reviewer.dao.SessionTimerDao;
import thesis.eng.reviewer.dao.SubCategoryTable;
import thesis.eng.reviewer.dao.SubCategoryTableDao;
import thesis.eng.reviewer.fragment.contract.LoadingContract;
import thesis.eng.reviewer.pojo.Category;
import thesis.eng.reviewer.pojo.Questionaire;
import thesis.eng.reviewer.pojo.Reviewer;
import thesis.eng.reviewer.pojo.Subcategory;
import thesis.eng.reviewer.service.RetrofitInstance;
import thesis.eng.reviewer.service.ReviewerCall;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public final class LoadingPresenter implements LoadingContract.Presenter {
    private LoadingContract.View view;
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final CategoryTableDao categoryDao= daoSession.getCategoryTableDao();
    private final SubCategoryTableDao subCategoryDao= daoSession.getSubCategoryTableDao();
    private final QuestionaireTableDao questionaireDao= daoSession.getQuestionaireTableDao();
    private final SessionTimerDao sessionTimerDao= daoSession.getSessionTimerDao();
    private ReviewerCall reviewerContract;

    public LoadingPresenter(LoadingContract.View view, WeakReference<Context> contextWeakReference){
        this.view=view;
        this.reviewerContract=new RetrofitInstance().getReviewService(contextWeakReference.get());
    }
    @Override
    public void downloadCategory() {
        Observable<Reviewer> observable = reviewerContract.getData();
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Reviewer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.restart();
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onNext(Reviewer reviewer) {
                        Log.e("category","OK");
                        beginFirstTransaction(reviewer);
                    }
                });
/*      try {
            Call<Reviewer> call = reviewerContract.getData();
            Response<Reviewer> response= call.execute();
            List <Category> categoryList = response.body().getCategory();
            List <Subcategory> subcategoryList = response.body().getSubcategory();
            for(Category category:categoryList){
                Log.e("Category",category.getCategoryname());
            }
            for(Subcategory subcategory:subcategoryList){
                Log.e("SubCategory",subcategory.getSubcategoryname());
            }
        } catch (IOException|NullPointerException e) {
            e.printStackTrace();
        }
*/
    }

    @Override
    public void downloadQuestionaire(final FragmentManager fragmentManager) {
        Observable<Questionaire> observable1 = reviewerContract.getQuestionaire();
        observable1.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Questionaire>() {
                    @Override
                    public void onCompleted() {
                        view.gotoHomeFragment();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("errorr",e.getMessage());
                        view.restart();
                    }

                    @Override
                    public void onNext(Questionaire questionaire) {
                        Log.e("questionaire", "OK");
                        beginSecondTransaction(questionaire);
                    }
                });
    }

    @Override
    public void beginFirstTransaction(Reviewer reviewer) {
        Database db = daoSession.getDatabase();
        try {
            db.beginTransaction();
            categoryDao.deleteAll();
            subCategoryDao.deleteAll();
            sessionTimerDao.deleteAll();
            saveCategory(reviewer.getCategory());
            saveSubcategory( reviewer.getSubcategory());
            SessionTimer sessionTimer1= new SessionTimer();
            sessionTimer1.setType("TIMED");
            sessionTimer1.setTime(reviewer.getCountdown());
            sessionTimerDao.insert(sessionTimer1);
            SessionTimer sessionTimer2= new SessionTimer();
            sessionTimer2.setType("UNTIMED");
            sessionTimer2.setTime("3600");
            sessionTimerDao.insert(sessionTimer2);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            db.endTransaction();
            Log.e("category","DONE");
        }

    }

    @Override
    public void saveCategory(List<Category> categoryList) {
        for (Category category : categoryList){
            CategoryTable categoryTable = new CategoryTable();
            Log.e("category",category.getCategoryname());
            categoryTable.setId(Long.valueOf(category.getCategoryid()));
            categoryTable.setCategoryname(category.getCategoryname());
            categoryDao.insert(categoryTable);
        }
    }

    @Override
    public void saveSubcategory(List<Subcategory> subcategoryList) {
        for (Subcategory subcategory :subcategoryList){
            SubCategoryTable subCategoryTable = new SubCategoryTable();
            Log.e("subcategory",subcategory.getSubcategoryname());
            subCategoryTable.setSubcategoryname(subcategory.getSubcategoryname());
            subCategoryTable.setCatId(Long.valueOf(subcategory.getCategoryid()));
            subCategoryTable.setId(Long.valueOf(subcategory.getSubcategoryid()));
            subCategoryDao.insert(subCategoryTable);
        }

    }

    @Override
    public void beginSecondTransaction(Questionaire questionaire) {
        Database db = daoSession.getDatabase();
        try {
            db.beginTransaction();
            questionaireDao.deleteAll();
            saveQuestionaire(questionaire.getQuestionaire());
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            Log.e("category", "DONE");
        }
    }

    @Override
    public void saveQuestionaire(List<Questionaire> questionaireList) {
        for (Questionaire n : questionaireList) {
            QuestionaireTable questionaires = new QuestionaireTable();
            Log.e("questionaire", n.getAnswer());
            questionaires.setAnswer(n.getAnswer());
            questionaires.setCategory(n.getCategoryname());
            questionaires.setCategoryID(Long.valueOf(n.getCategoryid()));
            questionaires.setSubCategoryID(Long.valueOf(n.getSubcategoryid()));
            questionaires.setNumberOfQuestion(Long.parseLong(n.getNumberofquestion()));
            questionaires.setOption1(n.getOption1());
            questionaires.setOption2(n.getOption2());
            questionaires.setOption3(n.getOption3());
            questionaires.setDirectory(n.getDirectory());
            questionaires.setPoints(Integer.parseInt(n.getPoints()));
            questionaires.setSubCategory(n.getSubcategoryname());
            questionaires.setQuestion(n.getQuestion());
            questionaireDao.insert(questionaires);
        }

    }

    @Override
    public boolean isCategoryTableEmpty() {
       return categoryDao.queryBuilder().limit(1).count()==0 || subCategoryDao.queryBuilder().limit(1).count()==0;
    }

    @Override
    public boolean isQuestionaireTableEmpty() {
        return questionaireDao.queryBuilder().limit(1).count()==0;
    }

}
