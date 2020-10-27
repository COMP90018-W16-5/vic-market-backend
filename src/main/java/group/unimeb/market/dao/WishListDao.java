package group.unimeb.market.dao;

import group.unimeb.market.model.WishList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface WishListDao {
    int deleteByPrimaryKey(Integer wlid);

    int insert(WishList record);

    int insertSelective(WishList record);

    WishList selectByPrimaryKey(Integer wlid);

    WishList selectByUserAndItem(@Param("uid") Integer uid,
                                 @Param("item") Integer item);

    int updateByPrimaryKeySelective(WishList record);

    int updateByPrimaryKey(WishList record);

    void deleteWishlist(WishList record);
}