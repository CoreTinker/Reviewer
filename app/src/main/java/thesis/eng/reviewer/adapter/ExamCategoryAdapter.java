package thesis.eng.reviewer.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.ButterKnife;
import thesis.eng.reviewer.adapter.view.ExamCategoryAdapterView;
import thesis.eng.reviewer.dao.CategoryTable;

/**
 * Created by jamesdeperio on 8/6/2017.
 */

public class ExamCategoryAdapter extends ExamCategoryAdapterView {
    private String type;
    public ExamCategoryAdapter(String type, WeakReference<FragmentActivity> activity, List<CategoryTable> categoryTables) {
        super(activity, categoryTables);
        this.type=type;
    }

    @Override
    protected void bindSimpleItemLayout(View view, final int position) {
        ButterKnife.bind(this,view);
        tvCategory.setText(categoryList.get(position).getCategoryname());
        flCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            gotoExamFragment(type,categoryList.get(position).getId(),categoryList.get(position).getCategoryname(),activity.get().getSupportFragmentManager());
            }
        });

    }


}
