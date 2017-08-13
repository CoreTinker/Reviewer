package thesis.eng.reviewer.fragment.view;

import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import library.jdp.jdppatternkotlin.base.BaseFragment;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.fragment.contract.QuestionFrontContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class QuestionFrontView extends BaseFragment implements QuestionFrontContract.View {
    @NotNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_quiz_front;
    }

    @Override
    public void bindTextDisplay(TextView textView, String text) {
        textView.setText(text);
    }
}
