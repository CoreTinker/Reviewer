package thesis.eng.reviewer.fragment;

import android.support.design.widget.NavigationView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import library.jdp.jdppatternkotlin.base.BaseFragment;
import thesis.eng.reviewer.R;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public class AboutFragment extends BaseFragment {
    @NotNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.about;
    }

    @Override
    protected void initComponents() {
        ((TextView)getActivity().findViewById(R.id.titletoolbar)).setText("About");
        ((NavigationView)getActivity().findViewById(R.id.nav_view)).setCheckedItem(R.id.nav_about);

    }

    @Override
    protected void initServices() {

    }
}
