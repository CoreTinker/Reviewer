package thesis.eng.reviewer.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.rey.material.widget.ProgressView;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.activity.view.MainView;
import thesis.eng.reviewer.fragment.presenter.LoadingPresenter;
import thesis.eng.reviewer.fragment.view.LoadingView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoadingFragment extends LoadingView {
    @BindView(R.id.progressBar) ProgressView progressView;
    private LoadingPresenter presenter;
    @Override
    protected void initComponents() {
        MainView.toggleWeakReference.get().setDrawerIndicatorEnabled(false);
        ((DrawerLayout)getActivity().findViewById(R.id.drawer_layout)).setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        getActivity().findViewById(R.id.btnGiveup).setVisibility(View.GONE);
        presenter= new LoadingPresenter(this, new WeakReference<>(getContext()));
     }

    @Override
    protected void initServices() {
        startProgressView(progressView);
        if(presenter.isCategoryTableEmpty())
            presenter.downloadCategory();
        if(presenter.isQuestionaireTableEmpty())
            presenter.downloadQuestionaire(getFragmentManager());
        else gotoHomeFragment();
    }

}