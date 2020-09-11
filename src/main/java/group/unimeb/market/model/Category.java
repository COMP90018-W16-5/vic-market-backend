package group.unimeb.market.model;

import java.io.Serializable;

/**
 * category
 * @author 
 */
public class Category implements Serializable {
    private Integer cid;

    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}