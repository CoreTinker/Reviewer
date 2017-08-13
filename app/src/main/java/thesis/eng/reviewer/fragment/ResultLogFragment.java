package thesis.eng.reviewer.fragment;


import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.fragment.view.ResultLogView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultLogFragment extends ResultLogView {
    private String questionNumber;
    private String questionPoints;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Long total;
    private String correctAnswer;
    private String yourAnswer;
    @BindView(R.id.questionNumber)
    TextView tvQN;
    @BindView(R.id.question) TextView tvQ;
    @BindView(R.id.questiontotal) TextView tvTotal;
    @BindView(R.id.option1)
    RadioButton opt1;
    @BindView(R.id.option2) RadioButton opt2;
    @BindView(R.id.option3) RadioButton opt3;
    @BindView(R.id.option4) RadioButton opt4;

    @Override
    protected void initComponents() {

    }

    @Override
    protected void initServices() {
        bindTotalPage(tvTotal,(questionNumber+"/"+total));
        bindQuestion(tvQ,question,tvQN,"Question #"+questionNumber+" ("+questionPoints+(questionPoints.equals("1")?" point":" points")+")");
        bindOption(opt1,option1,opt2,option2,opt3,option3,opt4,option4);
        checkAnswerIfCorrect(opt1,opt2,opt3,opt4,correctAnswer,yourAnswer);
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void setQuestionPoints(String questionPoints) {
        this.questionPoints = questionPoints;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setYourAnswer(String yourAnswer) {
        this.yourAnswer = yourAnswer;
    }
}
