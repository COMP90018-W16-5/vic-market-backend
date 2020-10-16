package group.unimeb.market;

import com.google.gson.Gson;
import group.unimeb.market.dao.CategoryDao;
import group.unimeb.market.dao.ItemDao;
import group.unimeb.market.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
class MarketApplicationTests {

    @Resource
    ItemService itemService;
    @Resource
    CategoryDao categoryDao;
    @Resource
    ItemDao itemDao;

    @Test
    void contextLoads() {
        System.out.println(itemDao.selectAllItemId());
//        System.out.println(new Gson().toJson(itemService.getSearchItemList("quad", 1, 10)));
//        System.out.println(new Gson().toJson(categoryDao.selectAll()));
//        System.out.println(new Gson().toJson(itemService.getItemListNearMe(1, 10, null, 20, new BigDecimal(23), new BigDecimal(123))));
    }

}
