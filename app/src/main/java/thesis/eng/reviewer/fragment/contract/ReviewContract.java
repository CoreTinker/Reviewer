package thesis.eng.reviewer.fragment.contract;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.List;

import thesis.eng.reviewer.dao.QuestionaireTable;
import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.fragment.QuestionFragment;
import thesis.eng.reviewer.fragment.QuizFrontFragment;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface ReviewContract {
    interface View {
        void hideDrawer();
        QuizFrontFragment getQuizFrontFragment(String catIDName, String subcatName);
    }
    interface Presenter {
        void shuffleOption(ReviewQuizTable reviewQuizTable, Byte order, QuestionFragment questionFragment, QuestionaireTable q);
        List<QuestionaireTable> loadQuestion(long subcatID, long catID, String catIDName, String subcatName);
        Long getQuestionCount(long subcatID, long catID);
        Long getTakenActivityCount();
        void setQuestionaireTable(Long totalLogs, QuestionaireTable q, List<ReviewQuizTable> reviewQuizTableList);
        Fragment getReviewQuizFinishFragment(List<ReviewQuizTable> reviewQuizTableList);

        QuestionFragment getQuestionFragment(ViewPager viewById, QuestionaireTable q, int x, List<ReviewQuizTable> reviewQuizTableList, Long questionCount);
    }
}
