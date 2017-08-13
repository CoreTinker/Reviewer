package thesis.eng.reviewer.fragment;


import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.fragment.view.QuestionView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends QuestionView {
    @BindView(R.id.questionNumber) TextView tvQN;
    @BindView(R.id.question) TextView tvQ;
    @BindView(R.id.questiontotal) TextView tvTotal;
    @BindView(R.id.option1) public RadioButton opt1;
    @BindView(R.id.option2) public RadioButton opt2;
    @BindView(R.id.option3) public RadioButton opt3;
    @BindView(R.id.option4) public RadioButton opt4;
    private String questionNumber;
    private String questionPoints;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Long total;
    private ReviewQuizTable reviewObject;
    private ViewPager viewPager;

    private void checkAnswer(RadioButton radioButton){
        if(reviewObject.getYourAnswer().equals(reviewObject.getCorrectAnswer())){
            radioButton.setBackgroundColor(Color.GREEN);
            Snackbar snackbar = Snackbar
                    .make(getRootView().findViewById(R.id.coord), "Correct!", 2000);
            snackbar.show();
        }else{
            radioButton.setBackgroundColor(Color.RED);
            if(reviewObject.getCorrectAnswer().equals(opt1.getText().toString())){
                opt1.setBackgroundColor(Color.GREEN);
            }else if(reviewObject.getCorrectAnswer().equals(opt2.getText().toString())){
                opt2.setBackgroundColor(Color.GREEN);
            }else if(reviewObject.getCorrectAnswer().equals(opt3.getText().toString())){
                opt3.setBackgroundColor(Color.GREEN);
            }else if(reviewObject.getCorrectAnswer().equals(opt4.getText().toString())){
                opt4.setBackgroundColor(Color.GREEN);
            }
            Snackbar snackbar = Snackbar
                    .make(getRootView().findViewById(R.id.coord), "Wrong Answer!", 2000);
            snackbar.show();
        }
        opt1.setEnabled(false);
        opt2.setEnabled(false);
        opt3.setEnabled(false);
        opt4.setEnabled(false);
        opt1.setTextColor(Color.BLACK);
        opt2.setTextColor(Color.BLACK);
        opt3.setTextColor(Color.BLACK);
        opt4.setTextColor(Color.BLACK);
    }
    @OnClick @OnCheckedChanged(R.id.option1) public void option1Action(){
        reviewObject.setYourAnswer(opt1.getText().toString());
        checkAnswer(opt1);
    }
    @OnClick  @OnCheckedChanged(R.id.option2) public void option2Action(){
        reviewObject.setYourAnswer(opt2.getText().toString());
        checkAnswer(opt2);
}
    @OnClick  @OnCheckedChanged(R.id.option3) public void option3Action(){
        reviewObject.setYourAnswer(opt3.getText().toString());
        checkAnswer(opt3);
    }
    @OnClick  @OnCheckedChanged (R.id.option4) public void option4Action(){
        reviewObject.setYourAnswer(opt4.getText().toString());
        checkAnswer(opt4);

    }

    @Override
    protected void initComponents() {}

    @Override
    protected void initServices() {
        bindTotalPage(tvTotal,(questionNumber+"/"+total));
        bindQuestion(tvQ,question,tvQN,"Question #"+questionNumber+" ("+questionPoints+(questionPoints.equals("1")?" point":" points")+")");
        bindOption(opt1,option1,opt2,option2,opt3,option3,opt4,option4);
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = String.valueOf(questionNumber);
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setReviewObject(ReviewQuizTable reviewObject) {
        this.reviewObject = reviewObject;
    }

    public void setQuestionPoints(String questionPoints) {
        this.questionPoints = questionPoints;
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }
}
