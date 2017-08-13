package thesis.eng.reviewer.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jamesdeperio on 8/9/2017.
 */
@Entity
public class SessionManager {
@Id private Long id;
    private boolean isLoggedIn;
    private String username;
    @Generated(hash = 978281478)
    public SessionManager(Long id, boolean isLoggedIn, String username) {
        this.id = id;
        this.isLoggedIn = isLoggedIn;
        this.username = username;
    }
    @Generated(hash = 847761979)
    public SessionManager() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean getIsLoggedIn() {
        return this.isLoggedIn;
    }
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
