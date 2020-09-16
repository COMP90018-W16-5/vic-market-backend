package group.unimeb.market.model;

import java.io.Serializable;

public class WishList implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer wlid;
    private Integer user;
    private Integer item;

    public WishList(Integer user, Integer item) {
        this.user = user;
        this.item = item;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getWlid() {
        return wlid;
    }

    public void setWlid(Integer wlid) {
        this.wlid = wlid;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }
}