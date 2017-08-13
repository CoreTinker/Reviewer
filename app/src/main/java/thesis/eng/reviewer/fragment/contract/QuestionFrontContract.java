package thesis.eng.reviewer.fragment.contract;

import android.widget.TextView;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface QuestionFrontContract {
    interface View {
        void bindTextDisplay(TextView textView,String text);
    }
}
