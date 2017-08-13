package thesis.eng.reviewer.adapter.contract;

import android.support.v4.app.FragmentManager;

import java.util.List;

import thesis.eng.reviewer.dao.SubCategoryTable;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface SubCategoryAdapterContract {
    interface View {
        void gotoQuiz(String nameCat, Long id, Long catId, String subcategoryname, FragmentManager supportFragmentManager);
        List<SubCategoryTable> filter(List<SubCategoryTable> subCategoryTableList, String query);
    }
    interface Adapter {
        void setFilter(List<SubCategoryTable> subCategoryTableList);
    }
}
