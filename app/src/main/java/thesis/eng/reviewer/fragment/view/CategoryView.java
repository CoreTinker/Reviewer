package thesis.eng.reviewer.fragment.view;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

import java.lang.ref.WeakReference;

import library.jdp.jdppatternkotlin.base.BaseFragment;
import library.jdp.jdppatternkotlin.helper.RecyclerAnim;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.activity.view.MainView;
import thesis.eng.reviewer.adapter.CategoryAdapter;
import thesis.eng.reviewer.fragment.contract.CategoryContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class CategoryView extends BaseFragment implements CategoryContract.View {
    @NonNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_category;
    }

    @Override
    public void initRecyclerView(RecyclerView recyclerView, CategoryAdapter adapter) {
        RecyclerAnim anim = new RecyclerAnim(new WeakReference<>(getActivity()));
        anim .setRecyclerView(new WeakReference<>(recyclerView))
                .setPocketAdapter(adapter)
                .commit();

    }

    @Override
    public void setSearchViewListener(SearchView searchView, SearchView.OnQueryTextListener search) {
        searchView.setOnQueryTextListener(search);
    }

    @Override
    public void unHideDrawer() {
        MainView.toggleWeakReference.get().setDrawerIndicatorEnabled(true);
        ((DrawerLayout)getActivity().findViewById(R.id.drawer_layout)).setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        getActivity().findViewById(R.id.btnGiveup).setVisibility(View.GONE);

    }
}
