package group.unimeb.market.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Url of user")
public class ImageUrlModel {
    private int seq;
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
