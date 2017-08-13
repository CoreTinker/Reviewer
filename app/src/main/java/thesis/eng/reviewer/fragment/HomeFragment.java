package thesis.eng.reviewer.fragment;


import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import library.jdp.jdppatternkotlin.base.BaseFragment;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.activity.view.MainView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    @NotNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initComponents() {
        ((DrawerLayout)getActivity().findViewById(R.id.drawer_layout)).setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        MainView.toggleWeakReference.get().setDrawerIndicatorEnabled(true);
        getActivity().findViewById(R.id.btnGiveup).setVisibility(View.GONE);
        ((TextView)getActivity().findViewById(R.id.titletoolbar)).setText("Home");
        ((NavigationView)getActivity().findViewById(R.id.nav_view)).setCheckedItem(R.id.nav_home);

    }

    @Override
    protected void initServices() {

    }
}
