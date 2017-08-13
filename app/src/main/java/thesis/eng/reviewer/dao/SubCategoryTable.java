package thesis.eng.reviewer.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jamesdeperio on 7/31/2017.
 */
@Entity
public class SubCategoryTable {
    @Id
    private Long id;
    private Long catId;
    @NotNull
    private String Subcategoryname;
    @Generated(hash = 434966977)
    public SubCategoryTable(Long id, Long catId, @NotNull String Subcategoryname) {
        this.id = id;
        this.catId = catId;
        this.Subcategoryname = Subcategoryname;
    }
    @Generated(hash = 136159553)
    public SubCategoryTable() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCatId() {
        return this.catId;
    }
    public void setCatId(Long catId) {
        this.catId = catId;
    }
    public String getSubcategoryname() {
        return this.Subcategoryname;
    }
    public void setSubcategoryname(String Subcategoryname) {
        this.Subcategoryname = Subcategoryname;
    }

}
