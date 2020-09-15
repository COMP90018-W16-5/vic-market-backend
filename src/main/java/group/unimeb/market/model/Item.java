package group.unimeb.market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * item
 *
 * @author
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(required = true, value = "Item id", dataType = "int", example = "1")
    private Integer itemId;
    @ApiModelProperty(required = true, value = "Item title", dataType = "String", example = "title")
    private String title;
    @ApiModelProperty(required = true, value = "Item description", dataType = "String", example = "description")
    private String description;
    @ApiModelProperty(required = true, value = "Item price", dataType = "double", example = "20.20")
    private Double price;
    @ApiModelProperty(required = true, value = "Item location latitude", dataType = "double", example = "37.8136")
    private BigDecimal latitude;
    @ApiModelProperty(required = true, value = "Item location longitude", dataType = "double", example = "144.9631")
    private BigDecimal longitude;
    @JsonIgnore
    private Integer seller;
    private Integer status;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getSeller() {
        return seller;
    }

    public void setSeller(Integer seller) {
        this.seller = seller;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}