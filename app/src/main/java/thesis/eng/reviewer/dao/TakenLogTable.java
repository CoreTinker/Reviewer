package thesis.eng.reviewer.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jamesdeperio on 8/5/2017.
 */
@Entity
public class TakenLogTable {
    @Id private Long id;
    @NotNull private String dateTaken;
    @NotNull private String type;
    @NotNull private String category;
    private String subcategory;
    private Long yourPoints;
    private Long overAllPoints;
    private String username;
    @Generated(hash = 1639286941)
    public TakenLogTable(Long id, @NotNull String dateTaken, @NotNull String type,
            @NotNull String category, String subcategory, Long yourPoints,
            Long overAllPoints, String username) {
        this.id = id;
        this.dateTaken = dateTaken;
        this.type = type;
        this.category = category;
        this.subcategory = subcategory;
        this.yourPoints = yourPoints;
        this.overAllPoints = overAllPoints;
        this.username = username;
    }
    @Generated(hash = 280176670)
    public TakenLogTable() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDateTaken() {
        return this.dateTaken;
    }
    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSubcategory() {
        return this.subcategory;
    }
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
    public Long getYourPoints() {
        return this.yourPoints;
    }
    public void setYourPoints(Long yourPoints) {
        this.yourPoints = yourPoints;
    }
    public Long getOverAllPoints() {
        return this.overAllPoints;
    }
    public void setOverAllPoints(Long overAllPoints) {
        this.overAllPoints = overAllPoints;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
