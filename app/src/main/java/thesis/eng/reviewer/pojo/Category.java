
package thesis.eng.reviewer.pojo;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("categoryid")
    private String mCategoryid;
    @SerializedName("categoryname")
    private String mCategoryname;

    public String getCategoryid() {
        return mCategoryid;
    }

    public void setCategoryid(String categoryid) {
        mCategoryid = categoryid;
    }

    public String getCategoryname() {
        return mCategoryname;
    }

    public void setCategoryname(String categoryname) {
        mCategoryname = categoryname;
    }

}
