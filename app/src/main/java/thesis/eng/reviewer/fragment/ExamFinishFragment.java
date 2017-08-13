package thesis.eng.reviewer.fragment;

import java.util.List;

import butterknife.OnClick;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.dao.ExamResultTable;
import thesis.eng.reviewer.fragment.presenter.ExamFinishPresenter;
import thesis.eng.reviewer.fragment.view.ExamFinishView;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public class ExamFinishFragment extends ExamFinishView {
    public ExamFinishPresenter presenter;
    public List<ExamResultTable> answersObject;
    @OnClick(R.id.btnSubmit) void submit(){
        showWarningDialog(answersObject,presenter);
    }

    @Override
    protected void initComponents() {
        presenter= new ExamFinishPresenter(this);
    }

    @Override
    protected void initServices() {

    }

    public void setAnswersObject(List<ExamResultTable> answersObject) {
        this.answersObject = answersObject;
    }


}
