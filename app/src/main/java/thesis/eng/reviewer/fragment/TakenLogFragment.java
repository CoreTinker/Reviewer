package thesis.eng.reviewer.fragment;


import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.fragment.presenter.TakenLogPresenter;
import thesis.eng.reviewer.fragment.view.TakenLogView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TakenLogFragment extends TakenLogView {
    TakenLogPresenter presenter;
    @Override
    protected void initComponents() {

        ((TextView)getActivity().findViewById(R.id.titletoolbar)).setText("Exam Result");
        ((NavigationView)getActivity().findViewById(R.id.nav_view)).setCheckedItem(R.id.nav_result);
        presenter= new TakenLogPresenter();

    }

    @Override
    protected void initServices() {
        unHideDrawer();
    }

    @Override
    protected void initPages() {
     /*
        LogRecyclerFragment practiceReview = new LogRecyclerFragment();
        practiceReview.setLogObject(presenter.getPracticeReviewObject(accountSessionManager));
        addPage("Practice Review", practiceReview);
        */
        LogRecyclerFragment exam = new LogRecyclerFragment();
        exam.setIsExam(true);
        exam.setLogObject(presenter.getExamObject());
        addPage("Exam Result", exam);
      }
}
