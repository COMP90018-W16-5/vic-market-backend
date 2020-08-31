package group.unimeb.market;

import com.google.gson.Gson;
import group.unimeb.market.dao.UserDao;
import group.unimeb.market.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MarketApplicationTests {

    @Resource
    UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println(new Gson().toJson(userDao.selectByPrimaryKey(1)));
    }

}
