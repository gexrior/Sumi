package cn.sumi.mapper;

import cn.sumi.pojo.BlogConfigure;
import org.springframework.stereotype.Repository;

/**
 * 博客配置DAO
 * Created by gonghf95 on 5/27/17.
 */
@Repository
public interface BlogConfigureMapper {
    BlogConfigure find(int userId);
    void add(BlogConfigure blogConfigure);
    void delete(int userId);
    void update(BlogConfigure blogConfigure);
}
