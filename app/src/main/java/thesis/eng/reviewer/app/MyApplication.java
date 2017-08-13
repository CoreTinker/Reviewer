package thesis.eng.reviewer.app;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.greenrobot.greendao.database.Database;

import thesis.eng.reviewer.dao.DaoMaster;
import thesis.eng.reviewer.dao.DaoSession;

/**
 * Created by jamesdeperio on 7/17/2017.
 */

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();
    private RequestQueue mRequestQueue;

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
    /***************888888888888888888888888888888888888************/

    private DaoSession daoSession;
    public DaoSession getDaoSession() {
        return daoSession;
    }
    private static MyApplication instance;
    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SqliteHandler helper = new SqliteHandler(this, "db_reviewer1" );
        Database db =helper.getEncryptedWritableDb("z09s8d7f6g");
         daoSession = new DaoMaster(db).newSession();
        instance = this;
    }
}
