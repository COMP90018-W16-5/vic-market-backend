package group.unimeb.market.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import group.unimeb.market.dao.ImageDao;
import group.unimeb.market.dao.ItemDao;
import group.unimeb.market.dao.WishListDao;
import group.unimeb.market.model.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 15/9/20
 */
@Service
public class WishlistService {
    @Resource
    private WishListDao wishListDao;
    @Resource
    private ItemDao itemDao;

    public void addWishlistItem(WishList wishList) {
        wishListDao.insert(wishList);
    }

    public void removeWishlistItem(WishList wishList) {
        wishListDao.deleteWishlist(wishList);
    }

    public PageResponseInfo<List<Item>> getWishlist(Integer page, Integer pageSize, Integer uid) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        List<Item> result;
        result = itemDao.selectWishlistByUser(uid);
        PageInfo<Item> pageInfo = new PageInfo<>(result);
        PageResponseInfo<List<Item>> responseInfo = PageResponseInfo.buildSuccess(result);
        responseInfo.setPage(pageInfo.getPageNum());
        responseInfo.setHasNext(pageInfo.isHasNextPage());
        responseInfo.setHasPrevious(pageInfo.isHasPreviousPage());
        return responseInfo;
    }
}
