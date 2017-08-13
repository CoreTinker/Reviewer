package thesis.eng.reviewer.adapter.contract;

import android.support.v4.app.FragmentManager;

import java.util.List;

import thesis.eng.reviewer.dao.TakenLogTable;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface TakenActivityContract {
    interface View {
        List<TakenLogTable> filter(List<TakenLogTable> categoryTableList, String query);
        void gotoResultLog(boolean isExam, Long id, FragmentManager supportFragmentManager);

    }
    interface Adapter {
        void setFilter(List<TakenLogTable> categoryTableList);
    }
}
