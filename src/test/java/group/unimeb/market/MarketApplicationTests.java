package group.unimeb.market;

import com.google.gson.Gson;
import group.unimeb.market.dao.ItemDao;
import group.unimeb.market.dao.UserDao;
import group.unimeb.market.model.User;
import group.unimeb.market.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MarketApplicationTests {

    @Resource
    ItemService itemService;

    @Test
    void contextLoads() {
        System.out.println(new Gson().toJson(itemService.getItemDetail(1)));
    }

}
