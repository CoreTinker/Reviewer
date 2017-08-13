package thesis.eng.reviewer.activity.view;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;

import java.lang.ref.WeakReference;

import cn.pedant.SweetAlert.SweetAlertDialog;
import library.jdp.jdppatternkotlin.base.BaseActivity;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.activity.contract.MainContract;
import thesis.eng.reviewer.fragment.CategoryFragment;
import thesis.eng.reviewer.fragment.LoadingFragment;
import thesis.eng.reviewer.helper.FragmentChange;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class MainView extends BaseActivity implements MainContract.View,  NavigationView.OnNavigationItemSelectedListener{
    public static WeakReference<ActionBarDrawerToggle> toggleWeakReference;
    @Override
    protected Object initLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void closeDrawer(DrawerLayout drawerLayout) {
        drawerLayout.closeDrawer(Gravity.START);
    }

    @Override
    public boolean isDrawerOpen(DrawerLayout drawerLayout) {
        return drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    @Override
    public void initDrawerToggle(Toolbar toolbar, DrawerLayout drawerLayout, NavigationView navigationView) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        toggleWeakReference= new WeakReference<>(toggle);
    }

    @Override
    public void gotoLoadScreen() {
        FragmentChange.load(R.id.fragmentContainer,getSupportFragmentManager(), new LoadingFragment());
    }

    @Override
    public void showWarningDialog() {
        SweetAlertDialog alertDialog = new SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE);
        alertDialog.setTitleText("Give up?")
                .setContentText("You will be redirect to home.")
                .setCancelText("No!").setConfirmText("Yes! :( ")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                }).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
                gotoCategoryFragment();
              }
        }).show();

    }

    @Override
    public void gotoCategoryFragment() {
        FragmentChange.load(R.id.fragmentContainer,getSupportFragmentManager(),new CategoryFragment());
    }

}
