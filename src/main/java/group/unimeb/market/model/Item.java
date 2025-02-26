package group.unimeb.market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
    @ApiModelProperty(required = true, value = "Item poster address", dataType = "String", example = "Parkville VIC 3010")
    private String Address;
    @ApiModelProperty(required = true, value = "Item location latitude", dataType = "double", example = "37.8136")
    private BigDecimal latitude;
    @ApiModelProperty(required = true, value = "Item location longitude", dataType = "double", example = "144.9631")
    private BigDecimal longitude;
    @ApiModelProperty(required = true, value = "Image urls", dataType = "List")
    private List<Image> urls;
    @JsonIgnore
    private Integer seller;
    private Integer status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public List<Image> getUrls() {
        return urls;
    }

    public void setUrls(List<Image> urls) {
        this.urls = urls;
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