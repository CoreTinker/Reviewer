package thesis.eng.reviewer.fragment;

import thesis.eng.reviewer.dao.ExamResultTable;
import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.fragment.presenter.ResultPresenter;
import thesis.eng.reviewer.fragment.view.ResultView;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public class ResultFragment extends ResultView {
    private Long id;
    private boolean isExam=false;
    private ResultPresenter presenter;
    @Override
    protected void initPages() {
        int x=1;
        if(isExam){
            Long questionCount =presenter.getQuestionExamCount(id);
            for(ExamResultTable reviewQuizTable : presenter.getExamTaken(id)){
                addPage("Q-"+x,presenter.getResultExamLogFragment(x,reviewQuizTable,questionCount));
                x++;
            }

        }else {
            Long questionCount =presenter.getQuestionCount(id);
            for(ReviewQuizTable reviewQuizTable : presenter.getActivityTaken(id)){
                addPage("Q-"+x,presenter.getResultLogFragment(x,reviewQuizTable,questionCount));
                x++;
            }
        }

    }

    @Override
    protected void initComponents() {
        presenter=new ResultPresenter();
    }

    @Override
    protected void initServices() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExam(boolean exam) {
        isExam = exam;
    }
}
