package thesis.eng.reviewer.fragment.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.eftimoff.viewpagertransformers.CubeOutTransformer;

import org.jetbrains.annotations.NotNull;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.activity.view.MainView;
import thesis.eng.reviewer.fragment.contract.TakenLogContract;
import thesis.eng.reviewer.helper.TabbedFragment;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class TakenLogView extends TabbedFragment implements TakenLogContract.View {
    @NotNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_taken_log;
    }

    @NotNull
    @Override
    protected ViewPager initViewPager() {
        return getRootView().findViewById(R.id.viewPager);
    }

    @NotNull
    @Override
    protected TabLayout initTabLayout() {
        return getRootView().findViewById(R.id.tabLayout);
    }
    @Override
    public void unHideDrawer() {
        MainView.toggleWeakReference.get().setDrawerIndicatorEnabled(true);
        ((DrawerLayout)getActivity().findViewById(R.id.drawer_layout)).setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        getActivity().findViewById(R.id.btnGiveup).setVisibility(View.GONE);

    }

    @NotNull
    @Override
    protected ViewPager.PageTransformer initPageTransformer() {
        return new CubeOutTransformer();
    }

}
