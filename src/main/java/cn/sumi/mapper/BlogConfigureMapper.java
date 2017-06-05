package cn.sumi.mapper;

import cn.sumi.po.BlogConfigure;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogConfigureMapper {
    int deleteByPrimaryKey(String account);

    int insert(BlogConfigure record);

    int insertSelective(BlogConfigure record);

    BlogConfigure find();

    int updateByPrimaryKeySelective(BlogConfigure record);

    int updateByPrimaryKey(BlogConfigure record);
}