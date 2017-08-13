package thesis.eng.reviewer.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jamesdeperio on 8/9/2017.
 */
@Entity
public class SessionTimer {
    @Id private Long id;
    private String type;
    private String time;
    @Generated(hash = 1179527412)
    public SessionTimer(Long id, String type, String time) {
        this.id = id;
        this.type = type;
        this.time = time;
    }
    @Generated(hash = 1385571631)
    public SessionTimer() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
