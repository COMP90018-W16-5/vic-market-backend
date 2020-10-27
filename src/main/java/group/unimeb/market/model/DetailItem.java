package group.unimeb.market.model;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

public class DetailItem {
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
    private Integer status;
    @ApiModelProperty(required = true, value = "Seller", dataType = "User")
    private User seller;
    @ApiModelProperty(required = true, value = "Image urls", dataType = "List")
    private List<Image> urls;
    @ApiModelProperty(required = true, value = "Image Categories", dataType = "List")
    private List<Category> categories;
    @ApiModelProperty(required = true, value = "Liked", dataType = "boolean", example = "false")
    private Boolean liked = false;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public List<Image> getUrls() {
        return urls;
    }

    public void setUrls(List<Image> urls) {
        this.urls = urls;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
}
