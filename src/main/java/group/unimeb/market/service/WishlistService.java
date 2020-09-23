package group.unimeb.market.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import group.unimeb.market.dao.ItemDao;
import group.unimeb.market.dao.WishListDao;
import group.unimeb.market.model.Item;
import group.unimeb.market.model.PageResponseInfo;
import group.unimeb.market.model.WishList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
