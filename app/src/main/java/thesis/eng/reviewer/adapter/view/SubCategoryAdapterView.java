package thesis.eng.reviewer.adapter.view;

import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import library.jdp.jdppatternkotlin.adapter.PocketAdapter;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.contract.SubCategoryAdapterContract;
import thesis.eng.reviewer.dao.SubCategoryTable;
import thesis.eng.reviewer.fragment.ReviewFragment;
import thesis.eng.reviewer.helper.FragmentChange;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class SubCategoryAdapterView extends PocketAdapter implements SubCategoryAdapterContract.View ,SubCategoryAdapterContract.Adapter {
    @Override
    public void gotoQuiz(String nameCat, Long id, Long catId, String subcategoryname, FragmentManager supportFragmentManager) {
        ReviewFragment reviewFragment= new ReviewFragment();
        reviewFragment.setCatID(catId);
        reviewFragment.setCatIDName(nameCat);
        reviewFragment.setSubcatID(id);
        reviewFragment.setSubcatName(subcategoryname);
        supportFragmentManager.popBackStackImmediate();
        FragmentChange.load(R.id.fragmentContainer,supportFragmentManager,reviewFragment);

    }
    @Override
    public List<SubCategoryTable> filter(List<SubCategoryTable> subCategoryTableList, String query) {
        query = query.toLowerCase();
        final List<SubCategoryTable> filteredModelList = new ArrayList<>();
        for (SubCategoryTable subCategoryTable : subCategoryTableList) {
            final String title = subCategoryTable.getSubcategoryname().toLowerCase();
            if (title.contains(query)) {
                filteredModelList.add(subCategoryTable);
            }
        }
        return filteredModelList;
    }
}
