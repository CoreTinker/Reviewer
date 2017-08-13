package thesis.eng.reviewer.activity.contract;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface MainContract {
    interface View {
        void gotoLoadScreen();
        boolean isDrawerOpen(DrawerLayout drawerLayout);
        void closeDrawer(DrawerLayout drawerLayout);
        void gotoCategoryFragment();
        void showWarningDialog();
        void initDrawerToggle(Toolbar toolbar, DrawerLayout drawerLayout, NavigationView navigationView);
    }
}
