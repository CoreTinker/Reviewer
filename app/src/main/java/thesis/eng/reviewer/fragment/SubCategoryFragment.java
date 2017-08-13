package thesis.eng.reviewer.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.rey.material.widget.Button;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.SubCategoryAdapter;
import thesis.eng.reviewer.dao.SubCategoryTable;
import thesis.eng.reviewer.fragment.presenter.SubCategoryPresenter;
import thesis.eng.reviewer.fragment.view.SubCategoryView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubCategoryFragment extends SubCategoryView {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.searchView)  SearchView searchView;
    @BindView(R.id.btnBack) Button btnback;
    private long idCat;
    private String nameCat;
    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }
    private SubCategoryPresenter presenter;
    private SubCategoryAdapter adapter;
    private List<SubCategoryTable> subCategoryTableList;
    @OnClick(R.id.btnBack) void back(){
        getActivity().onBackPressed();
    }
    @Override
    protected void initComponents() {
        presenter= new SubCategoryPresenter(this);
        subCategoryTableList=presenter.getSubcategoryList(idCat);
        adapter=new SubCategoryAdapter(new WeakReference<>(getActivity()),subCategoryTableList,nameCat);
    }
    @Override
    protected void initServices() {
        bindDisplayText(btnback,"< "+ nameCat);
        setSearchViewListener(searchView,search);
        initRecyclerView(recyclerView,adapter);
    }
    private final SearchView.OnQueryTextListener search=new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String text) {
            return false;
        }
        @Override
        public boolean onQueryTextChange(String text) {
            final List<SubCategoryTable> filteredList = adapter.filter(subCategoryTableList,text);
            adapter.setFilter(filteredList);
            return false;
        }
    };


    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }
}
