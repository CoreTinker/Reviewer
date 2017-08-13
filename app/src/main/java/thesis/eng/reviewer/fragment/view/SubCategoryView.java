package thesis.eng.reviewer.fragment.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import library.jdp.jdppatternkotlin.base.BaseFragment;
import library.jdp.jdppatternkotlin.helper.RecyclerAnim;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.SubCategoryAdapter;
import thesis.eng.reviewer.fragment.contract.SubCategoryContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class SubCategoryView extends BaseFragment implements SubCategoryContract.View {
    @NonNull
    @Override
    protected Object initLayoutRes() {
        return R.layout.fragment_sub_category;
    }

    @Override
    public void initRecyclerView(RecyclerView recyclerView, SubCategoryAdapter adapter) {
        RecyclerAnim anim = new RecyclerAnim(new WeakReference<>(getActivity()));
        anim .setRecyclerView(new WeakReference<>(recyclerView))
                .setPocketAdapter(adapter)
                .commit();

    }

    @Override
    public void bindDisplayText(TextView textView, String text) {
        textView.setText(text);
    }

    @Override
    public void setSearchViewListener(SearchView searchView, SearchView.OnQueryTextListener listener) {
        searchView.setOnQueryTextListener(listener);
    }
}
