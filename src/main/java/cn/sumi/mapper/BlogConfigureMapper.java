package cn.sumi.mapper;

import cn.sumi.pojo.BlogConfigure;

/**
 * 博客配置DAO
 * Created by gonghf95 on 5/27/17.
 */
public interface BlogConfigureMapper {
    BlogConfigure find(int uid);
    void add(BlogConfigure blogConfigure);
    void delete(BlogConfigure blogConfigure);
    void update(BlogConfigure blogConfigure);
}
