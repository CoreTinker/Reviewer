package thesis.eng.reviewer.fragment.contract;

import java.util.List;

import thesis.eng.reviewer.dao.TakenLogTable;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface TakenLogContract {
    interface View {
        void unHideDrawer();
    }
    interface Presenter {
        List<TakenLogTable> getExamObject();
     }
}
