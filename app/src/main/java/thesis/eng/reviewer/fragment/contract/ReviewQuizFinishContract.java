package thesis.eng.reviewer.fragment.contract;

import java.util.List;

import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.fragment.presenter.ReviewQuizFinishPresenter;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface ReviewQuizFinishContract {
    interface View {
        void showWarningDialog(List<ReviewQuizTable> answersObject, ReviewQuizFinishPresenter presenter);
        void gotoActivityTakenFragment();
    }
    interface Presenter {
        void insertQuizRecord(ReviewQuizTable reviewQuizTable);
        void insertTakenLog(List<ReviewQuizTable> reviewQuizTables);
        void submitActivity(List<ReviewQuizTable> answersObject);
        Long computeScore(List<ReviewQuizTable> foreignKey);
        Long getTotalPoints(List<ReviewQuizTable> reviewQuizTables);
    }
}
