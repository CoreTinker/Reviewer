package thesis.eng.reviewer.adapter.contract;

import android.support.v4.app.FragmentManager;

import java.util.List;

import thesis.eng.reviewer.dao.CategoryTable;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface CategoryAdapterContract {
    interface View {
        void gotoSubCategory(Long id, String categoryname, FragmentManager supportFragmentManager);
        List<CategoryTable> filter(List<CategoryTable> categoryTableList, String query);
    }
    interface Adapter {
        void setFilter(List<CategoryTable> categoryTableList);
    }
}
