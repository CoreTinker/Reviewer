package thesis.eng.reviewer.fragment;


import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.CategoryAdapter;
import thesis.eng.reviewer.dao.CategoryTable;
import thesis.eng.reviewer.fragment.presenter.CategoryPresenter;
import thesis.eng.reviewer.fragment.view.CategoryView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends CategoryView {
    protected CategoryPresenter categoryPresenter;
    protected List<CategoryTable> categoryTableList;
    protected CategoryAdapter adapter;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.searchView) SearchView searchView;
    @Override
    protected void initComponents() {
        ((TextView)getActivity().findViewById(R.id.titletoolbar)).setText("Practice Review");
        ((NavigationView)getActivity().findViewById(R.id.nav_view)).setCheckedItem(R.id.nav_review);
        categoryPresenter = new CategoryPresenter(this);
        categoryTableList= categoryPresenter.getCategoryList();
        adapter=new CategoryAdapter(new WeakReference<>(getActivity()),categoryTableList);
    }

    @Override
    protected void initServices() {
        unHideDrawer();
        initRecyclerView(recyclerView,adapter);
        setSearchViewListener(searchView,search);
    }

    private final SearchView.OnQueryTextListener search=new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String text) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String text) {
            final List<CategoryTable> filteredList = adapter.filter(categoryTableList,text);
            adapter.setFilter(filteredList);
            return false;
        }
    };


}
