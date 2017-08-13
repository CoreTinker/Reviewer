package thesis.eng.reviewer.adapter.view;

import android.support.v4.app.FragmentManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import library.jdp.jdppatternkotlin.adapter.PocketAdapter;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.contract.TakenActivityContract;
import thesis.eng.reviewer.dao.TakenLogTable;
import thesis.eng.reviewer.fragment.ResultFragment;
import thesis.eng.reviewer.helper.FragmentChange;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class TakenActivityView extends PocketAdapter implements TakenActivityContract.Adapter,TakenActivityContract.View {

    @Override
    public List<TakenLogTable> filter(List<TakenLogTable> takenLogTables, String query) {
        query = query.toLowerCase();
        final List<TakenLogTable> filteredModelList = new ArrayList<>();
        for (TakenLogTable takenLogTable : takenLogTables) {
            final String date = String.valueOf(takenLogTable.getDateTaken());
            final String category =takenLogTable.getCategory();
            final String subcategory =takenLogTable.getSubcategory();
            if (date.contains(query)||category.contains(query)||subcategory.contains(query)) {
                filteredModelList.add(takenLogTable);
            }
        }
        return filteredModelList;
    }

    @Override
    public void gotoResultLog(boolean isExam, Long id, FragmentManager supportFragmentManager) {
        ResultFragment resultFragment= new ResultFragment();
        resultFragment.setId(id);
        resultFragment.setExam(isExam);
        Log.e("exam?", String.valueOf(isExam));
        supportFragmentManager.popBackStackImmediate();
        FragmentChange.load(R.id.fragmentContainer,supportFragmentManager,resultFragment);


    }
}
