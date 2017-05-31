package cn.sumi.mapper;

import cn.sumi.pojo.Post;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Post record) throws DataAccessException;

    int insertSelective(Post record) throws DataAccessException;

    Post selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKeyWithBLOBs(Post record);

    int updateByPrimaryKey(Post record);
}