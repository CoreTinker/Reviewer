package thesis.eng.reviewer.fragment.view;

import android.graphics.Color;
import android.widget.RadioButton;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import library.jdp.jdppatternkotlin.base.BaseFragment;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.fragment.contract.QuestionContract;
import thesis.eng.reviewer.fragment.contract.ResultViewContract;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public abstract class ResultLogView extends BaseFragment implements QuestionContract.View, ResultViewContract.View {
    @NotNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_question;
    }
    @Override
    public void bindTotalPage(TextView textView, String text) {
        textView.setText(text);
    }

    @Override
    public void bindQuestion(TextView question, String text, TextView number, String num) {
        question.setText(text);
        number.setText(num);
    }

    @Override
    public void bindOption(RadioButton rd1, String txt1, RadioButton rd2, String txt2, RadioButton rd3, String txt3, RadioButton rd4, String txt4) {
        rd1.setText(txt1);
        rd2.setText(txt2);
        rd3.setText(txt3);
        rd4.setText(txt4);
        rd1.setEnabled(false);
        rd3.setEnabled(false);
        rd2.setEnabled(false);
        rd4.setEnabled(false);
        rd1.setTextColor(Color.BLACK);
        rd2.setTextColor(Color.BLACK);
        rd3.setTextColor(Color.BLACK);
        rd4.setTextColor(Color.BLACK);
    }

    @Override
    public void checkAnswerIfCorrect(RadioButton rd1, RadioButton rd2, RadioButton rd3, RadioButton rd4, String correctAnswer, String yourAnswer) {
        if(correctAnswer.equals(yourAnswer)){
            if(yourAnswer.equals(rd1.getText().toString())){
                rd1.setChecked(true);
                rd1.setBackgroundColor(Color.GREEN);
            }else if(yourAnswer.equals(rd2.getText().toString())){
                rd2.setChecked(true);
                rd2.setBackgroundColor(Color.GREEN);
            }else if(yourAnswer.equals(rd3.getText().toString())){
                rd3.setChecked(true);
                rd3.setBackgroundColor(Color.GREEN);
            }else if(yourAnswer.equals(rd4.getText().toString())){
                rd4.setChecked(true);
                rd4.setBackgroundColor(Color.GREEN);
            }
        }else {
            if(yourAnswer.equals(rd1.getText().toString())){
                rd1.setChecked(true);
                rd1.setBackgroundColor(Color.RED);
            }else if(yourAnswer.equals(rd2.getText().toString())){
                rd2.setChecked(true);
                rd2.setBackgroundColor(Color.RED);
            }else if(yourAnswer.equals(rd3.getText().toString())){
                rd3.setChecked(true);
                rd3.setBackgroundColor(Color.RED);
            }else if(yourAnswer.equals(rd4.getText().toString())){
                rd4.setChecked(true);
                rd4.setBackgroundColor(Color.RED);
            }
            if(correctAnswer.equals(rd1.getText().toString())){
                rd1.setBackgroundColor(Color.GREEN);
            }else if(correctAnswer.equals(rd2.getText().toString())){
                rd2.setBackgroundColor(Color.GREEN);
            }else if(correctAnswer.equals(rd3.getText().toString())){
                rd3.setBackgroundColor(Color.GREEN);
            }else if(correctAnswer.equals(rd4.getText().toString())){
                rd4.setBackgroundColor(Color.GREEN);
            }
        }

    }
}
