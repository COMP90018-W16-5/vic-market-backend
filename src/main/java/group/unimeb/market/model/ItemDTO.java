package group.unimeb.market.model;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 15/9/20
 */
public class ItemDTO {
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
    @ApiModelProperty(required = true, value = "Image urls", dataType = "list", example = "[\"https://url/image1.png\",\"https://url/image2.png\"]")
    private List<String> images;
    @ApiModelProperty(required = true, value = "Category ids", dataType = "list", example = "[1, 2, 3]")
    private List<Integer> categories;

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }
}
