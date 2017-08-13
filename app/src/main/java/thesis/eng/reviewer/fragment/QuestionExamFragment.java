package thesis.eng.reviewer.fragment;

import thesis.eng.reviewer.dao.ExamResultTable;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public class QuestionExamFragment extends QuestionFragment {
    private ExamResultTable examResultTable;
    @Override
    public void option1Action() {
        examResultTable.setYourAnswer(opt1.getText().toString());
    }

    @Override
    public void option2Action() {
        examResultTable.setYourAnswer(opt2.getText().toString());
    }

    @Override
    public void option3Action() {
        examResultTable.setYourAnswer(opt3.getText().toString());
    }

    @Override
    public void option4Action() {
        examResultTable.setYourAnswer(opt4.getText().toString());
    }

    public void setExamResultTable(ExamResultTable examResultTable) {
        this.examResultTable = examResultTable;
    }
}
