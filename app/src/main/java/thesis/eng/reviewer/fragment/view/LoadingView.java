package thesis.eng.reviewer.fragment.view;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.rey.material.widget.ProgressView;

import cn.pedant.SweetAlert.SweetAlertDialog;
import library.jdp.jdppatternkotlin.base.BaseFragment;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.fragment.HomeFragment;
import thesis.eng.reviewer.fragment.LoadingFragment;
import thesis.eng.reviewer.fragment.contract.LoadingContract;
import thesis.eng.reviewer.helper.FragmentChange;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class LoadingView extends BaseFragment implements LoadingContract.View {

    @NonNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_loading;
    }

    @Override
    public void startProgressView(ProgressView progressView) {
        progressView.start();
    }

    @Override
    public void gotoHomeFragment() {
        FragmentChange.load(R.id.fragmentContainer,getFragmentManager(), new HomeFragment());
    }

    @Override
    public void restart() {
        final FragmentManager fragmentManager= getFragmentManager();
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getContext(),SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setTitleText("Ooopss!")
                .setContentText("Connection Problem..")
                .setConfirmText("Try Again!")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        FragmentChange.load(R.id.fragmentContainer,fragmentManager,new LoadingFragment());
                    }
                }).show();
    }
}
