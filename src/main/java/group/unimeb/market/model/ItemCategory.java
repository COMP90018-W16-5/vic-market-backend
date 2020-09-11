package group.unimeb.market.model;

import java.io.Serializable;

/**
 * item_category
 * @author 
 */
public class ItemCategory implements Serializable {
    private Integer icid;

    private Integer item;

    private Integer cid;

    private static final long serialVersionUID = 1L;

    public Integer getIcid() {
        return icid;
    }

    public void setIcid(Integer icid) {
        this.icid = icid;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}