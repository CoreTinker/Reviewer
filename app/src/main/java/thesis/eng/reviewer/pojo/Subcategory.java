
package thesis.eng.reviewer.pojo;

import com.google.gson.annotations.SerializedName;

public class Subcategory {

    @SerializedName("categoryid")
    private String mCategoryid;
    @SerializedName("subcategoryid")
    private String mSubcategoryid;
    @SerializedName("subcategoryname")
    private String mSubcategoryname;

    public String getCategoryid() {
        return mCategoryid;
    }

    public void setCategoryid(String categoryid) {
        mCategoryid = categoryid;
    }

    public String getSubcategoryid() {
        return mSubcategoryid;
    }

    public void setSubcategoryid(String subcategoryid) {
        mSubcategoryid = subcategoryid;
    }

    public String getSubcategoryname() {
        return mSubcategoryname;
    }

    public void setSubcategoryname(String subcategoryname) {
        mSubcategoryname = subcategoryname;
    }

}
