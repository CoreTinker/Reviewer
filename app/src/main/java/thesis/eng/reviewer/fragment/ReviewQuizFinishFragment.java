package thesis.eng.reviewer.fragment;


import android.support.v4.app.Fragment;

import java.util.List;

import butterknife.OnClick;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.fragment.presenter.ReviewQuizFinishPresenter;
import thesis.eng.reviewer.fragment.view.ReviewQuizFinishView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewQuizFinishFragment extends ReviewQuizFinishView {

    private ReviewQuizFinishPresenter presenter;
    private List<ReviewQuizTable> answersObject;
    @OnClick(R.id.btnSubmit) void submit(){
       showWarningDialog(answersObject,presenter);
    }

    @Override
    protected void initComponents() {
        presenter= new ReviewQuizFinishPresenter(this);
    }

    @Override
    protected void initServices() {}

    public void setAnswersObject(List<ReviewQuizTable> answersObject) {
        this.answersObject = answersObject;
    }
}
