package thesis.eng.reviewer.fragment.view;

import android.support.annotation.NonNull;
import android.widget.RadioButton;
import android.widget.TextView;

import library.jdp.jdppatternkotlin.base.BaseFragment;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.fragment.contract.QuestionContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class QuestionView extends BaseFragment implements QuestionContract.View {

    @NonNull
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
    public void bindOption(RadioButton rd1, String txt1,RadioButton rd2, String txt2,RadioButton rd3, String txt3,RadioButton rd4, String txt4) {
       rd1.setText(txt1);
       rd2.setText(txt2);
       rd3.setText(txt3);
       rd4.setText(txt4);
    }
}
