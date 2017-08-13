package thesis.eng.reviewer.fragment.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.eftimoff.viewpagertransformers.DefaultTransformer;

import org.jetbrains.annotations.NotNull;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.helper.TabbedFragment;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public abstract class ResultView extends TabbedFragment {
    @NotNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_result;
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


    @NotNull
    @Override
    protected ViewPager.PageTransformer initPageTransformer() {
        return new DefaultTransformer();
    }

}
