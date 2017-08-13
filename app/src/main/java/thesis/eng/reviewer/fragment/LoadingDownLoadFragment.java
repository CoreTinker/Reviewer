package thesis.eng.reviewer.fragment;

import android.widget.TextView;

import java.lang.ref.WeakReference;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.fragment.presenter.LoadingPresenter;

/**
 * Created by jamesdeperio on 8/9/2017.
 */

public class LoadingDownLoadFragment extends LoadingFragment {
    @Override
    protected void initServices() {
        ((TextView)getActivity().findViewById(R.id.titletoolbar)).setText("");
        startProgressView(progressView);
        LoadingPresenter presenter = new LoadingPresenter(this, new WeakReference<>(getContext()));

        presenter.downloadCategory();
        presenter.downloadQuestionaire(getFragmentManager());
       }
}
