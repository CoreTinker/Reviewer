package thesis.eng.reviewer.fragment.contract;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.List;

import thesis.eng.reviewer.adapter.CategoryAdapter;
import thesis.eng.reviewer.dao.CategoryTable;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface CategoryContract {
    interface View {
        void  unHideDrawer();
        void setSearchViewListener(SearchView searchView, SearchView.OnQueryTextListener search);
        void initRecyclerView(RecyclerView recyclerView, CategoryAdapter adapter);
    }
    interface Presenter {
        List<CategoryTable> getCategoryList();
    }
}
