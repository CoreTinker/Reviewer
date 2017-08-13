package thesis.eng.reviewer.adapter.view;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.lang.ref.WeakReference;
import java.util.List;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.CategoryAdapter;
import thesis.eng.reviewer.adapter.contract.ExamCategoryAdapterContract;
import thesis.eng.reviewer.dao.CategoryTable;
import thesis.eng.reviewer.fragment.ExamFragment;
import thesis.eng.reviewer.helper.FragmentChange;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public abstract class ExamCategoryAdapterView extends CategoryAdapter implements ExamCategoryAdapterContract.View {
    public ExamCategoryAdapterView(WeakReference<FragmentActivity> activity, List<CategoryTable> categoryTables) {
        super(activity, categoryTables);
    }

    @Override
    public void gotoExamFragment(String type, Long catid, String catname, FragmentManager fragmentManager) {
        ExamFragment examFragment= new ExamFragment();
        examFragment.setCatID(catid);
        examFragment.setCatName(catname);
        examFragment.setType(type);
        FragmentChange.load(R.id.fragmentContainer,fragmentManager,examFragment);
    }
}
