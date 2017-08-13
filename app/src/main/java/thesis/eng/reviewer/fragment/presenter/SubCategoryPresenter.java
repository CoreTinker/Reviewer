package thesis.eng.reviewer.fragment.presenter;

import java.util.List;

import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.SubCategoryTable;
import thesis.eng.reviewer.dao.SubCategoryTableDao;
import thesis.eng.reviewer.fragment.contract.SubCategoryContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public final class SubCategoryPresenter implements SubCategoryContract.Presenter {
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final SubCategoryTableDao subCategoryTableDao= daoSession.getSubCategoryTableDao();
    private SubCategoryContract.View view;
    public SubCategoryPresenter(SubCategoryContract.View view){
        this.view=view;
    }

    @Override
    public List<SubCategoryTable> getSubcategoryList(long idCat) {
        return subCategoryTableDao.queryBuilder().where(SubCategoryTableDao.Properties.CatId.eq(idCat)).orderAsc(SubCategoryTableDao.Properties.Subcategoryname).list();
    }
}
