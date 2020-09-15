package group.unimeb.market.model;

import java.io.Serializable;

/**
 * category
 *
 * @author
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cid;
    private String name;

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