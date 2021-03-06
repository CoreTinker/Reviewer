package thesis.eng.reviewer.fragment.view;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import library.jdp.jdppatternkotlin.base.BaseFragment;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.dao.ReviewQuizTable;
import thesis.eng.reviewer.fragment.TakenLogFragment;
import thesis.eng.reviewer.fragment.contract.ReviewQuizFinishContract;
import thesis.eng.reviewer.fragment.presenter.ReviewQuizFinishPresenter;
import thesis.eng.reviewer.helper.FragmentChange;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class ReviewQuizFinishView extends BaseFragment implements ReviewQuizFinishContract.View {
    @NotNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_review_quiz_finish;
    }

    @Override
    public void showWarningDialog(final List<ReviewQuizTable> answersObject, final ReviewQuizFinishPresenter presenter) {
        SweetAlertDialog alertDialog = new SweetAlertDialog(getActivity(),SweetAlertDialog.WARNING_TYPE);
        alertDialog.setTitleText("Are you sure?")
                .setContentText("You can now view the result after this.")
                .setCancelText("Wait!").setConfirmText("OK!")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                }).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
                presenter.submitActivity(answersObject);
            }
        }).show();


    }

    @Override
    public void gotoActivityTakenFragment() {
        FragmentChange.load(R.id.fragmentContainer,getActivity().getSupportFragmentManager(),new TakenLogFragment());
    }
}
