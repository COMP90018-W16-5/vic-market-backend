package group.unimeb.market.dao;

import group.unimeb.market.model.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemDao {
    int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}