package thesis.eng.reviewer.adapter.view;

import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import library.jdp.jdppatternkotlin.adapter.PocketAdapter;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.adapter.contract.CategoryAdapterContract;
import thesis.eng.reviewer.dao.CategoryTable;
import thesis.eng.reviewer.fragment.SubCategoryFragment;
import thesis.eng.reviewer.helper.FragmentChange;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public abstract class CategoryAdapterView extends PocketAdapter implements CategoryAdapterContract.View, CategoryAdapterContract.Adapter {
    @Override
    public void gotoSubCategory(Long id, String categoryname, FragmentManager supportFragmentManager) {
        SubCategoryFragment subCategoryFragment= new SubCategoryFragment();
        subCategoryFragment.setIdCat(id);
        subCategoryFragment.setNameCat(categoryname);
        FragmentChange.loadWithBackStack(R.id.fragmentContainer,supportFragmentManager,subCategoryFragment);
    }

    @Override
    public List<CategoryTable> filter(List<CategoryTable> categoryTableList, String query) {
        query = query.toLowerCase();
        final List<CategoryTable> filteredModelList = new ArrayList<>();
        for (CategoryTable categoryTable : categoryTableList) {
            final String title = categoryTable.getCategoryname().toLowerCase();
            if (title.contains(query)) {
                filteredModelList.add(categoryTable);
            }
        }
        return filteredModelList;
    }


}