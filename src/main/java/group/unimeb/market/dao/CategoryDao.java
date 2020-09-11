package group.unimeb.market.dao;

import group.unimeb.market.model.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao {
    int deleteByPrimaryKey(Integer cid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}