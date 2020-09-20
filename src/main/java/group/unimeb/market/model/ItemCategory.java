package group.unimeb.market.model;

import java.io.Serializable;

/**
 * item_category
 *
 * @author
 */
public class ItemCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer icid;
    private Integer item;
    private Integer cid;

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

    public ItemCategory(Integer icid, Integer item, Integer cid) {
        this.icid = icid;
        this.item = item;
        this.cid = cid;
    }

    public ItemCategory() {
    }
}