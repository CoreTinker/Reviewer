package thesis.eng.reviewer.fragment;


import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.dao.QuestionaireTable;
import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.fragment.presenter.ReviewPresenter;
import thesis.eng.reviewer.fragment.view.ReviewView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewFragment extends ReviewView {
    private long subcatID;
    private long catID;
    private String subcatName;
    private String catIDName;
    private ReviewPresenter presenter;
    @Override
    protected void initPages() {
        addPage("Introduction",getQuizFrontFragment(catIDName,subcatName));
        List<ReviewQuizTable> reviewQuizTableList = new ArrayList<>();
        int x=0;
        Random rand = new Random();
        Long questionCount =presenter.getQuestionCount(subcatID,catID);
        for(QuestionaireTable q:presenter.loadQuestion(subcatID,catID,catIDName,subcatName)){
            presenter.setQuestionaireTable(presenter.getTakenActivityCount()+1,q,reviewQuizTableList);
            QuestionFragment questionFragment = presenter.getQuestionFragment((ViewPager) getRootView().findViewById(R.id.viewPager),q,x,reviewQuizTableList,questionCount);
            presenter.shuffleOption(reviewQuizTableList.get(x),(byte) (rand.nextInt(7) + 1),questionFragment,q);
            addPage("Q-"+(x+1),questionFragment);
            x++;
        }
     //   addPage("Complete",presenter.getReviewQuizFinishFragment(reviewQuizTableList));
    }



    @Override
    protected void initComponents() {
        presenter = new ReviewPresenter();
     }

    @Override
    protected void initServices() {
        hideDrawer();


        new CountDownTimer(1500, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {

                ((ViewPager)getRootView().findViewById(R.id.viewPager)).setCurrentItem(1);

            }



        }.start();


    }

    public void setSubcatID(long subcatID) {
        this.subcatID = subcatID;
    }

    public void setCatID(long catID) {
        this.catID = catID;
    }


    public void setSubcatName(String subcatName) {
        this.subcatName = subcatName;
    }

    public void setCatIDName(String catIDName) {
        this.catIDName = catIDName;
    }
}
