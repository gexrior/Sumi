package cn.sumi.mapper;

import cn.sumi.pojo.BlogConfigure;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogConfigureMapper {
    int insert(BlogConfigure record);

    int insertSelective(BlogConfigure record);
}