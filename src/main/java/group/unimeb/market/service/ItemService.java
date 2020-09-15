package group.unimeb.market.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import group.unimeb.market.dao.ItemDao;
import group.unimeb.market.model.Item;
import group.unimeb.market.model.PageResponseInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 15/9/20
 */
@Service
public class ItemService {
    @Resource
    private ItemDao itemDao;

    public PageResponseInfo<List<Item>> getItemList(Integer page, Integer pageSize, Integer category) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        List<Item> result;
        if (category == null || category.equals(0)) {
            result = itemDao.selectAll();
        } else {
            result = itemDao.selectByCategory(category);
        }
        PageInfo<Item> pageInfo = new PageInfo<>(result);
        PageResponseInfo<List<Item>> responseInfo = PageResponseInfo.buildSuccess(result);
        responseInfo.setPage(pageInfo.getPageNum());
        responseInfo.setHasNext(pageInfo.isHasNextPage());
        responseInfo.setHasPrevious(pageInfo.isHasPreviousPage());
        return responseInfo;
    }
}
