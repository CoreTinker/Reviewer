package thesis.eng.reviewer.fragment.contract;

import android.support.v4.app.FragmentManager;

import com.rey.material.widget.ProgressView;

import java.util.List;

import thesis.eng.reviewer.pojo.Category;
import thesis.eng.reviewer.pojo.Questionaire;
import thesis.eng.reviewer.pojo.Reviewer;
import thesis.eng.reviewer.pojo.Subcategory;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public interface LoadingContract {
    interface View {
        void startProgressView(ProgressView progressView);
        void gotoHomeFragment();

        void restart();
    }
    interface Presenter {
        void downloadCategory();
        void downloadQuestionaire(FragmentManager fragmentManager);
        void beginFirstTransaction(Reviewer reviewer);
        void saveCategory(List<Category> categoryList);
        void saveSubcategory(List<Subcategory> subcategoryList);
        void beginSecondTransaction(Questionaire questionaire);
        void saveQuestionaire(List<Questionaire> questionaireList);
        boolean isCategoryTableEmpty();
        boolean isQuestionaireTableEmpty();
    }
}
