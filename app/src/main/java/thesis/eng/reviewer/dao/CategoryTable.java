package thesis.eng.reviewer.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jamesdeperio on 7/31/2017.
 */
@Entity
public class CategoryTable {
    @Id
    private Long id;
    @NotNull
    private String Categoryname;
    @Generated(hash = 1414306784)
    public CategoryTable(Long id, @NotNull String Categoryname) {
        this.id = id;
        this.Categoryname = Categoryname;
    }
    @Generated(hash = 1679078959)
    public CategoryTable() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategoryname() {
        return this.Categoryname;
    }
    public void setCategoryname(String Categoryname) {
        this.Categoryname = Categoryname;
    }
   }
