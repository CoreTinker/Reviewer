package thesis.eng.reviewer.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.TakenActivityAdapter;
import thesis.eng.reviewer.dao.TakenLogTable;
import thesis.eng.reviewer.fragment.view.LogRecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogRecyclerFragment extends LogRecyclerView {
    private List<TakenLogTable> logObject;
    private TakenActivityAdapter adapter;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.searchView) SearchView searchView;
    private boolean isExam;

    @Override
    protected void initComponents() {
       adapter= new TakenActivityAdapter(isExam,new WeakReference<>(getActivity()),logObject);
       }



    @Override
    protected void initServices() {
        initRecyclerView(recyclerView,adapter );
        setSearchViewListener(searchView,search);
    }

    public void setLogObject(List<TakenLogTable> logObject) {
        this.logObject = logObject;
    }
    private final SearchView.OnQueryTextListener search=new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String text) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String text) {
            final List<TakenLogTable> filteredList = adapter.filter(logObject,text);
            adapter.setFilter(filteredList);
            return false;
        }
    };


    public void setIsExam(boolean isExam) {
        this.isExam = isExam;
    }
}
