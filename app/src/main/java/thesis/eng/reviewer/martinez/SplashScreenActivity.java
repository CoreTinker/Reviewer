package thesis.eng.reviewer.martinez;

/**
 * Created by Joshua on 4/24/2017.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import thesis.eng.reviewer.R;
import thesis.eng.reviewer.activity.MainActivity;
import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.SessionManagerDao;

public class SplashScreenActivity extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final SessionManagerDao sessionManagerDao= daoSession.getSessionManagerDao();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                 /* Create an Intent that will start the Menu-Activity. */
                try{
                    boolean sessionManager=sessionManagerDao.queryBuilder().where(SessionManagerDao.Properties.IsLoggedIn.eq(true)).orderDesc(SessionManagerDao.Properties.Id).limit(1).unique().getIsLoggedIn();
                    if(sessionManager){
                        Intent mainIntent = new Intent(SplashScreenActivity.this,MainActivity.class);
                        SplashScreenActivity.this.startActivity(mainIntent);
                        SplashScreenActivity.this.finish();
                    }else {
                        Intent mainIntent = new Intent(SplashScreenActivity.this,LoginActivity.class);
                        SplashScreenActivity.this.startActivity(mainIntent);
                        SplashScreenActivity.this.finish();

                    }

                }catch (NullPointerException e){
                    e.printStackTrace();
                    Intent mainIntent = new Intent(SplashScreenActivity.this,LoginActivity.class);
                    SplashScreenActivity.this.startActivity(mainIntent);
                    SplashScreenActivity.this.finish();
                }
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}