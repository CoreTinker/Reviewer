package thesis.eng.reviewer.fragment.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.eftimoff.viewpagertransformers.DefaultTransformer;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.activity.view.MainView;
import thesis.eng.reviewer.fragment.QuizFrontFragment;
import thesis.eng.reviewer.fragment.contract.ReviewContract;
import thesis.eng.reviewer.helper.TabbedFragment;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class ReviewView extends TabbedFragment implements ReviewContract.View {
    @NonNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_review;
    }

    @NonNull
    @Override
    protected ViewPager initViewPager() {
        return getRootView().findViewById(R.id.viewPager);
    }

    @NonNull
    @Override
    protected TabLayout initTabLayout() {
        return getRootView().findViewById(R.id.tabLayout);
    }

    @Nullable
    @Override
    protected ViewPager.PageTransformer initPageTransformer() {
        return new DefaultTransformer();
    }

    @Override
    public void hideDrawer() {
        MainView.toggleWeakReference.get().setDrawerIndicatorEnabled(false);
        ((DrawerLayout)getActivity().findViewById(R.id.drawer_layout)).setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        getActivity().findViewById(R.id.btnGiveup).setVisibility(View.VISIBLE);
    }

    @Override
    public QuizFrontFragment getQuizFrontFragment(String catIDName, String subcatName) {
        QuizFrontFragment quizFrontFragment = new QuizFrontFragment();
        quizFrontFragment.setCatName(catIDName);
        quizFrontFragment.setSubCatName(subcatName.trim().isEmpty()?"":"("+subcatName+")");
        quizFrontFragment.setTitle(subcatName.trim().isEmpty()?"EXAMINATION":"REVIEWER");
        return quizFrontFragment;
    }
}
