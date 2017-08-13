package thesis.eng.reviewer.fragment.contract;

import android.widget.TextView;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface QuestionContract {
    interface View {
        void bindTotalPage(TextView textView,String text);
        void bindQuestion(TextView question,String text,TextView number,String num);
        void bindOption(android.widget.RadioButton rd1, String txt1, android.widget.RadioButton rd2, String txt2, android.widget.RadioButton rd3, String txt3, android.widget.RadioButton rd4, String txt4);
    }
}
