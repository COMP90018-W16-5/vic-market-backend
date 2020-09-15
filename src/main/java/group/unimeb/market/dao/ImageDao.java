package group.unimeb.market.dao;

import group.unimeb.market.model.Image;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageDao {
    int deleteByPrimaryKey(Integer imid);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer imid);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
}