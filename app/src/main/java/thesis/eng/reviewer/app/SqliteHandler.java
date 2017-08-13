package thesis.eng.reviewer.app;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import thesis.eng.reviewer.dao.DaoMaster;

/**
 * Created by Chee Kiat on 15/03/2017.
 */

public class SqliteHandler extends DaoMaster.DevOpenHelper {
    SqliteHandler(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
