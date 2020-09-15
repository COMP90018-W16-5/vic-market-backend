package group.unimeb.market.model;

import java.io.Serializable;

public class Image implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer imid;
    private Integer item;
    private String url;

    public Image(Integer imid, Integer item, String url) {
        this.imid = imid;
        this.item = item;
        this.url = url;
    }
}