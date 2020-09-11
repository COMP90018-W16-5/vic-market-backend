package group.unimeb.market.dao;

import group.unimeb.market.dao.ItemCategory;

public interface ItemCategoryDao {
    int deleteByPrimaryKey(Integer icid);

    int insert(ItemCategory record);

    int insertSelective(ItemCategory record);

    ItemCategory selectByPrimaryKey(Integer icid);

    int updateByPrimaryKeySelective(ItemCategory record);

    int updateByPrimaryKey(ItemCategory record);
}