package cn.sumi.mapper;

import cn.sumi.pojo.BlogConfigure;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogConfigureMapper {
    int deleteByPrimaryKey(String account);

    int insert(BlogConfigure record);

    int insertSelective(BlogConfigure record);

    BlogConfigure selectByPrimaryKey(String account);

    int updateByPrimaryKeySelective(BlogConfigure record);

    int updateByPrimaryKey(BlogConfigure record);
}