package group.unimeb.market.dao;

import group.unimeb.market.model.DetailItem;
import group.unimeb.market.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemDao {
    int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> selectAll();

    List<Item> selectWishlistByUser(Integer uid);

    List<Item> selectByCategory(int category);

    DetailItem selectDetailItem(Integer itemId);
}