package group.unimeb.market.dao;

import group.unimeb.market.model.ItemCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemCategoryDao {
    int deleteByPrimaryKey(Integer icid);

    int insert(ItemCategory record);

    int insertSelective(ItemCategory record);

    ItemCategory selectByPrimaryKey(Integer icid);

    int updateByPrimaryKeySelective(ItemCategory record);

    int updateByPrimaryKey(ItemCategory record);
}