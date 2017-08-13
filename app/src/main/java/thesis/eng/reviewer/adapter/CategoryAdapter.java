package thesis.eng.reviewer.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.rey.material.widget.FrameLayout;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.view.CategoryAdapterView;
import thesis.eng.reviewer.dao.CategoryTable;

/**
 * Created by jamesdeperio on 7/29/2017.
 */

public class CategoryAdapter extends CategoryAdapterView {
    public CategoryAdapter(WeakReference<FragmentActivity> activity, List<CategoryTable> categoryTables){
        setSimpleItemLayout(R.layout.list_item_category);
        this.activity=activity;
        this.categoryList=categoryTables;
    }

    protected List<CategoryTable> categoryList;
    protected WeakReference<FragmentActivity> activity;
    @BindView(R.id.tvCategory)
    protected TextView tvCategory;
    @BindView(R.id.cardView)
    protected FrameLayout flCardView;
    @Override
    protected void bindSimpleItemLayout(View view, final int position) {
        ButterKnife.bind(this,view);
        tvCategory.setText(categoryList.get(position).getCategoryname());
        flCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSubCategory(categoryList.get(position).getId(),categoryList.get(position).getCategoryname(),activity.get().getSupportFragmentManager());
            }
        });
    }
    @Override
    public void setFilter(List<CategoryTable> categoryTableList) {
        this.categoryList = categoryTableList;
        notifyDataSetChanged();
    }
    @Override protected int getDataCount() {
        return categoryList.size();
    }
}
