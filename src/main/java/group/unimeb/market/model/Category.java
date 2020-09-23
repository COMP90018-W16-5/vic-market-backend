package group.unimeb.market.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * category
 *
 * @author
 */
public class Category {
    @ApiModelProperty(required = true, value = "Category id", dataType = "int", example = "1")
    private Integer cid;
    @ApiModelProperty(required = true, value = "Category name", dataType = "int", example = "Smart phone")
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