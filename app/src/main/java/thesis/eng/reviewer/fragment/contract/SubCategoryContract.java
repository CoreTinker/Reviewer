package thesis.eng.reviewer.fragment.contract;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import java.util.List;

import thesis.eng.reviewer.adapter.SubCategoryAdapter;
import thesis.eng.reviewer.dao.SubCategoryTable;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface SubCategoryContract {
    interface View {
        void bindDisplayText(TextView textView, String text);
        void setSearchViewListener(SearchView searchView, SearchView.OnQueryTextListener listener);
        void initRecyclerView(RecyclerView recyclerView, SubCategoryAdapter subCategoryAdapter);
    }
    interface Presenter {
        List<SubCategoryTable> getSubcategoryList(long idCat);
    }
}
