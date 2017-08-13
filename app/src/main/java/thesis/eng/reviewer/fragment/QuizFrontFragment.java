package thesis.eng.reviewer.fragment;


import android.support.v4.app.Fragment;
import android.widget.TextView;

import butterknife.BindView;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.fragment.view.QuestionFrontView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFrontFragment extends QuestionFrontView {
    private String catName;
    private String subCatName;
    @BindView(R.id.tvCategory)
    TextView tvCategory;
    @BindView(R.id.tvSubCategory)
    TextView tvSubCategory;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    private String title;

    @Override
    protected void initComponents() { }

    @Override
    protected void initServices() {
        bindTextDisplay(tvCategory,catName.toUpperCase());
        bindTextDisplay(tvTitle,title);
        bindTextDisplay(tvSubCategory,subCatName);
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
