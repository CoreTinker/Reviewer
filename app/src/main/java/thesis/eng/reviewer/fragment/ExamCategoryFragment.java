package thesis.eng.reviewer.fragment;

import android.support.design.widget.NavigationView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.ExamCategoryAdapter;
import thesis.eng.reviewer.fragment.presenter.CategoryPresenter;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public class ExamCategoryFragment extends CategoryFragment {
    private String type;

    @Override
    protected void initComponents() {
        ((TextView)getActivity().findViewById(R.id.titletoolbar)).setText("Examination");
        ((NavigationView)getActivity().findViewById(R.id.nav_view)).setCheckedItem(R.id.nav_exam);
        categoryPresenter = new CategoryPresenter(this);
        categoryTableList= categoryPresenter.getCategoryList();
        adapter=new ExamCategoryAdapter(type,new WeakReference<>(getActivity()),categoryTableList);

    }

    public void setType(String type) {
        this.type = type;
    }
}
