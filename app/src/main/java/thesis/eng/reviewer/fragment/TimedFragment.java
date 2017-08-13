package thesis.eng.reviewer.fragment;


import android.support.v4.app.Fragment;

import org.jetbrains.annotations.NotNull;

import butterknife.OnClick;
import library.jdp.jdppatternkotlin.base.BaseFragment;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.helper.FragmentChange;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimedFragment extends BaseFragment {
    @OnClick(R.id.btnUntimed) void untimed(){
        ExamCategoryFragment examCategoryFragment=new ExamCategoryFragment();
        examCategoryFragment.setType("UNTIMED");
        FragmentChange.load(R.id.fragmentContainer,getFragmentManager(),examCategoryFragment);

    }

    @OnClick(R.id.btn_Timed) void timed(){
        ExamCategoryFragment examCategoryFragment=new ExamCategoryFragment();
        examCategoryFragment.setType("TIMED");
        FragmentChange.load(R.id.fragmentContainer,getFragmentManager(),examCategoryFragment);
    }
    @NotNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_timed;
    }

    @Override
    protected void initComponents() {

    }

    @Override
    protected void initServices() {

    }
}
