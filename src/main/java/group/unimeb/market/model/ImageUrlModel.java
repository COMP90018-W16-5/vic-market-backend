package group.unimeb.market.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Url of user")
public class ImageUrlModel {
    @ApiModelProperty(required = true, value = "Sequence number", dataType = "Int", example = "1")
    private int seq;
    @ApiModelProperty(required = true, value = "URL", dataType = "String", example = "https://url/img.png")
    private String url;

    public ImageUrlModel(int seq, String url) {
        this.seq = seq;
        this.url = url;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
