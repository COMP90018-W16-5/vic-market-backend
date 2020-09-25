package group.unimeb.market;

import com.google.gson.Gson;
import group.unimeb.market.dao.CategoryDao;
import group.unimeb.market.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MarketApplicationTests {

    @Resource
    ItemService itemService;
    @Resource
    CategoryDao categoryDao;

    @Test
    void contextLoads() {
//        System.out.println(new Gson().toJson(itemService.getSearchItemList("quad", 1, 10)));
        System.out.println(new Gson().toJson(categoryDao.selectAll()));
    }

}
