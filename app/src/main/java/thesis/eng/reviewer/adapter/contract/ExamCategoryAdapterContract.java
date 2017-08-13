package thesis.eng.reviewer.adapter.contract;

import android.support.v4.app.FragmentManager;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public interface ExamCategoryAdapterContract {
    interface View {
        void gotoExamFragment(String type, Long catid, String catname, FragmentManager fragmentManager);
    }
}
