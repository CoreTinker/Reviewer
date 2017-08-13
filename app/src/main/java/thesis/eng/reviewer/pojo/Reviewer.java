
package thesis.eng.reviewer.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Reviewer {

    @SerializedName("category")
    private List<Category> mCategory;
    @SerializedName("countdown")
    private String mCountdown;
    @SerializedName("subcategory")
    private List<Subcategory> mSubcategory;

    public List<Category> getCategory() {
        return mCategory;
    }

    public void setCategory(List<Category> category) {
        mCategory = category;
    }

    public String getCountdown() {
        return mCountdown;
    }

    public void setCountdown(String countdown) {
        mCountdown = countdown;
    }

    public List<Subcategory> getSubcategory() {
        return mSubcategory;
    }

    public void setSubcategory(List<Subcategory> subcategory) {
        mSubcategory = subcategory;
    }

}
