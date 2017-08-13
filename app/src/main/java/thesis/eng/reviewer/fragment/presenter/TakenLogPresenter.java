package thesis.eng.reviewer.fragment.presenter;

import java.util.List;

import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.SessionManagerDao;
import thesis.eng.reviewer.dao.TakenLogTable;
import thesis.eng.reviewer.dao.TakenLogTableDao;
import thesis.eng.reviewer.fragment.contract.TakenLogContract;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public final class TakenLogPresenter implements TakenLogContract.Presenter {
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final TakenLogTableDao takenLogTableDao= daoSession.getTakenLogTableDao();
    private final SessionManagerDao sessionManagerDao= daoSession.getSessionManagerDao();


    @Override
    public List<TakenLogTable> getExamObject() {
        String username = sessionManagerDao.queryBuilder().orderDesc(SessionManagerDao.Properties.Id).unique().getUsername();
        return takenLogTableDao.queryBuilder().where(TakenLogTableDao.Properties.Type.eq("EXAM"),
                TakenLogTableDao.Properties.Username.eq(username)).orderAsc(TakenLogTableDao.Properties.Id).list();
    }

}
