package thesis.eng.reviewer.fragment.contract;

import java.util.List;

import thesis.eng.reviewer.dao.ExamResultTable;
import thesis.eng.reviewer.fragment.presenter.ExamFinishPresenter;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public interface ExamFinishContract {
    interface View {
        void showWarningDialog(List<ExamResultTable> examResultTableList, ExamFinishPresenter presenter);
        void gotoActivityTakenFragment();
    }
    interface Presenter {
        void insertQuizRecord(ExamResultTable examResultTable);
        void insertTakenLog(List<ExamResultTable> examResultTableList);
        void submitActivity(List<ExamResultTable> examResultTableList);
        Long computeScore(List<ExamResultTable> foreignKey);
        Long getTotalPoints(List<ExamResultTable> examResultTableList);
    }
}
