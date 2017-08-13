package thesis.eng.reviewer.fragment.contract;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import thesis.eng.reviewer.adapter.TakenActivityAdapter;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface LogRecyclerContract {
    interface View {
        void initRecyclerView(RecyclerView recyclerView, TakenActivityAdapter adapter);
        void setSearchViewListener(SearchView searchView, SearchView.OnQueryTextListener listener);
    }
}
