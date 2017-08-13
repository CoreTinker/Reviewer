package thesis.eng.reviewer.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.rey.material.widget.LinearLayout;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.view.TakenActivityView;
import thesis.eng.reviewer.dao.TakenLogTable;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public class TakenActivityAdapter extends TakenActivityView {
    private List<TakenLogTable> takenLogTableList;
    private WeakReference<FragmentActivity> activity;
    private boolean isExam;
    public TakenActivityAdapter(boolean isExam, WeakReference<FragmentActivity> fragmentActivityWeakReference, List<TakenLogTable> takenLogTables){
        this.isExam=isExam;
        this.activity=fragmentActivityWeakReference;
        this.takenLogTableList=takenLogTables;
        setSimpleItemLayout(R.layout.list_item_activitylog);
    }
    @BindView(R.id.tvDate) TextView tvDate;
    @BindView(R.id.tvCategory) TextView tvCat;
    @BindView(R.id.tvSubCategory) TextView tvSubCat;
    @BindView(R.id.tvScore) TextView tvScore;
    @BindView(R.id.cardView)
    LinearLayout flCardView;
    @Override
    protected void bindSimpleItemLayout(View view, final int position) {
        ButterKnife.bind(this,view);
        tvDate.setText(takenLogTableList.get(position).getDateTaken().toString());
        tvSubCat.setText(takenLogTableList.get(position).getSubcategory());
        tvCat.setText("("+takenLogTableList.get(position).getCategory()+")");
        tvScore.setText(takenLogTableList.get(position).getYourPoints()+"/"+takenLogTableList.get(position).getOverAllPoints());
        flCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoResultLog(isExam,takenLogTableList.get(position).getId(),activity.get().getSupportFragmentManager());
            }
        });
    }

    @Override
    public void setFilter(List<TakenLogTable> takenLogTables) {
        this.takenLogTableList = takenLogTables;
        notifyDataSetChanged();
    }
    @Override protected int getDataCount() {
        return takenLogTableList.size();
    }
}
