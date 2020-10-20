package group.unimeb.market.dao;

import group.unimeb.market.model.DetailItem;
import group.unimeb.market.model.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
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

    List<Item> selectSearch(String keyword);

    List<Item> selectWishlistByUser(Integer uid);

    List<Item> selectByCategory(Integer category);

    List<Item> selectBySeller(Integer uid);

    DetailItem selectDetailItem(Integer itemId);

    List<Item> selectNearMe(@Param("minLatitude") BigDecimal minLatitude,
                            @Param("maxLatitude") BigDecimal maxLatitude,
                            @Param("minLongitude") BigDecimal minLongitude,
                            @Param("maxLongitude") BigDecimal maxLongitude,
                            @Param("category") Integer category);

    List<Integer> selectAllItemId();
}