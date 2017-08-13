package thesis.eng.reviewer.fragment.contract;

import android.support.v4.app.Fragment;

import java.util.List;

import thesis.eng.reviewer.dao.ExamResultTable;
import thesis.eng.reviewer.dao.ReviewQuizTable;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public interface ResultContract {
    interface Presenter {
        List<ReviewQuizTable> getActivityTaken(Long id);
        Fragment getResultLogFragment(int x, ReviewQuizTable reviewQuizTable, Long questionCount);
        Long getQuestionCount(Long id);

        Long getQuestionExamCount(Long id);

        List<ExamResultTable> getExamTaken(Long id);

        Fragment getResultExamLogFragment(int x, ExamResultTable reviewQuizTable, Long questionCount);
    }

}
