package thesis.eng.reviewer.fragment.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;

import library.jdp.jdppatternkotlin.base.BaseFragment;
import library.jdp.jdppatternkotlin.helper.RecyclerAnim;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.TakenActivityAdapter;
import thesis.eng.reviewer.fragment.contract.LogRecyclerContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class LogRecyclerView extends BaseFragment implements LogRecyclerContract.View {
    @NotNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_log_recycler;
    }
    @Override
    public void initRecyclerView(RecyclerView recyclerView, TakenActivityAdapter adapter) {
        RecyclerAnim anim = new RecyclerAnim(new WeakReference<>(getActivity()));
        anim .setRecyclerView(new WeakReference<>(recyclerView))
                .setPocketAdapter(adapter)
                .commit();
    }

    @Override
    public void setSearchViewListener(SearchView searchView, SearchView.OnQueryTextListener listener) {
        searchView.setOnQueryTextListener(listener);
    }
}
