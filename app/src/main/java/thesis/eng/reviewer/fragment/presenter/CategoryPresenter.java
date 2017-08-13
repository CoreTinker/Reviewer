package thesis.eng.reviewer.fragment.presenter;

import java.util.List;

import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.CategoryTable;
import thesis.eng.reviewer.dao.CategoryTableDao;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.fragment.contract.CategoryContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public final class CategoryPresenter implements CategoryContract.Presenter {
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final CategoryTableDao categoryDao= daoSession.getCategoryTableDao();
    private CategoryContract.View view;
    public CategoryPresenter(CategoryContract.View view){
        this.view=view;
    }

    @Override
    public List<CategoryTable> getCategoryList() {
        return  categoryDao.queryBuilder().orderAsc(CategoryTableDao.Properties.Categoryname).list();
    }
}
