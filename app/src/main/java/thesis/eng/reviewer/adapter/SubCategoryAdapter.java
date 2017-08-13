package thesis.eng.reviewer.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.rey.material.widget.FrameLayout;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.view.SubCategoryAdapterView;
import thesis.eng.reviewer.dao.SubCategoryTable;

/**
 * Created by jamesdeperio on 8/3/2017.
 */

public class SubCategoryAdapter extends SubCategoryAdapterView {
    private List<SubCategoryTable> subCategoryTableList= new ArrayList<>();
    private WeakReference<FragmentActivity> activity;
    private String nameCat;
    public SubCategoryAdapter(WeakReference<FragmentActivity> fragmentActivityWeakReference, List<SubCategoryTable> subCategoryTableList, String nameCat) {
        this.nameCat=nameCat;
        this.activity=fragmentActivityWeakReference;
        this.subCategoryTableList=subCategoryTableList;
        setSimpleItemLayout(R.layout.list_item_category);

    }

    @Override
    protected int getDataCount() {
        return subCategoryTableList.size();
    }
    @Override
    public void setFilter(List<SubCategoryTable> subCategoryTableList) {
        this.subCategoryTableList = subCategoryTableList;
        notifyDataSetChanged();
    }

    @BindView(R.id.tvCategory) TextView tvCategory;
    @BindView(R.id.cardView) FrameLayout flCardView;

    @Override
    protected void bindSimpleItemLayout(View view, final int position) {
        ButterKnife.bind(this,view);
        tvCategory.setText(subCategoryTableList.get(position).getSubcategoryname());
        flCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoQuiz(nameCat,subCategoryTableList.get(position).getId(),
                        subCategoryTableList.get(position).getCatId(),
                        subCategoryTableList.get(position).getSubcategoryname(),
                        activity.get().getSupportFragmentManager());
            }
        });
    }

}
