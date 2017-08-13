package thesis.eng.reviewer.fragment.contract;

import android.support.v4.app.Fragment;

import java.util.List;

import thesis.eng.reviewer.dao.ExamResultTable;
import thesis.eng.reviewer.dao.QuestionaireTable;
import thesis.eng.reviewer.dao.SubCategoryTable;
import thesis.eng.reviewer.fragment.QuestionExamFragment;
import thesis.eng.reviewer.fragment.QuestionFragment;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public interface ExamContract {
    interface Presenter {
        Long getSubcategoryCount(Long id);
        List<QuestionaireTable> loadQuestion(Long catID);
        List<SubCategoryTable> getSubcategoryList(Long caID);
        int getTotalQuestionCount(Long catID);
        Fragment getExamFinishFragment(List<ExamResultTable> reviewQuizTableList);

        void shuffleOption(ExamResultTable examResultTable, Byte order, QuestionFragment questionFragment, QuestionaireTable q);
        Long getTakenActivityCount();
        void setQuestionaireTable(Long totalLogs, QuestionaireTable q, List<ExamResultTable> examResultTable);
        QuestionExamFragment getQuestionFragment(QuestionaireTable q, int x, List<ExamResultTable> examResultTable, Long total);
    }
}
