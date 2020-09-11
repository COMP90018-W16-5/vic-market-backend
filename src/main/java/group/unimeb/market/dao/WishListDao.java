package group.unimeb.market.dao;

import group.unimeb.market.model.WishList;

public interface WishListDao {
    int deleteByPrimaryKey(Integer wlid);

    int insert(WishList record);

    int insertSelective(WishList record);

    WishList selectByPrimaryKey(Integer wlid);

    int updateByPrimaryKeySelective(WishList record);

    int updateByPrimaryKey(WishList record);
}