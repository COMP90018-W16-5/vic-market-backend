package group.unimeb.market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class Image {
    @ApiModelProperty(required = true, value = "Image id", dataType = "int", example = "1")
    private Integer imid;
    @JsonIgnore
    private Integer item;
    @ApiModelProperty(required = true, value = "Image URL", dataType = "String", example = "https://url/img.png")
    private String url;

    public Image() {
    }

    public Image(Integer item, String url) {
        this.item = item;
        this.url = url;
    }

    public Integer getImid() {
        return imid;
    }

    public void setImid(Integer imid) {
        this.imid = imid;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}