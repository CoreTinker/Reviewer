package thesis.eng.reviewer.fragment.contract;

import android.widget.RadioButton;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public interface ResultViewContract {
     interface View {
        void checkAnswerIfCorrect(RadioButton rd1, RadioButton rd2, RadioButton rd3, RadioButton rd4, String correctAnswer, String yourAnswer);
    }
}
