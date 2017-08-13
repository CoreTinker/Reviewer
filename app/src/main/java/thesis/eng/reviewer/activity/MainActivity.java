package thesis.eng.reviewer.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.OnClick;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.activity.view.MainView;
import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.SessionManagerDao;
import thesis.eng.reviewer.fragment.AboutFragment;
import thesis.eng.reviewer.fragment.CategoryFragment;
import thesis.eng.reviewer.fragment.HomeFragment;
import thesis.eng.reviewer.fragment.LoadingDownLoadFragment;
import thesis.eng.reviewer.fragment.TakenLogFragment;
import thesis.eng.reviewer.fragment.TimedFragment;
import thesis.eng.reviewer.helper.FragmentChange;
import thesis.eng.reviewer.martinez.LoginActivity;

public class MainActivity extends MainView {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @OnClick(R.id.btnGiveup) void back(){
        showWarningDialog();
    }
    @Override
    protected Toolbar initSupportingActionBar() {
        return toolbar;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                FragmentChange.load(R.id.fragmentContainer,getSupportFragmentManager(), new HomeFragment());break;
            case R.id.nav_review:
                FragmentChange.load(R.id.fragmentContainer,getSupportFragmentManager(), new CategoryFragment());break;
            case R.id.nav_exam:
                FragmentChange.load(R.id.fragmentContainer,getSupportFragmentManager(), new TimedFragment());break;
            case R.id.nav_result:
                FragmentChange.load(R.id.fragmentContainer,getSupportFragmentManager(), new TakenLogFragment());break;
            case R.id.nav_about:
                FragmentChange.load(R.id.fragmentContainer,getSupportFragmentManager(), new AboutFragment());break;
            case R.id.nav_download:
                FragmentChange.load(R.id.fragmentContainer,getSupportFragmentManager(), new LoadingDownLoadFragment());break;
            case R.id.nav_logout:
                sessionManager.deleteAll();
               startActivity(new Intent(this,LoginActivity.class));
                finish();
        }
       closeDrawer(drawerLayout);
        return true;
    }
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final SessionManagerDao sessionManager= daoSession.getSessionManagerDao();

    @Override
    protected void initComponents() {
        initDrawerToggle(toolbar,drawerLayout,navigationView);
        gotoLoadScreen();
//        String uname="Welcome, "+sessionManager.queryBuilder().orderDesc(SessionManagerDao.Properties.Id).limit(1).unique().getUsername()+"!";
   //     ((TextView)navigationView.getHeaderView(0).findViewById(R.id.tvUsername)).setText(uname);

    }

    @Override
    protected void initServices() {

    }

    @Override
    public void onBackPressed() {
        if (isDrawerOpen(drawerLayout)) closeDrawer(drawerLayout);
        else super.onBackPressed();
    }

}
