package mapper;

import base.BaseConfiguration;
import cn.sumi.mapper.BlogConfigureMapper;
import cn.sumi.po.BlogConfigure;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 博客配置DAO测试
 * Created by gonghf95 on 5/27/17.
 */
public class BlogConfigureMapperUnit extends BaseConfiguration{

    Logger logger = Logger.getLogger(BlogConfigureMapperUnit.class);
    @Autowired
    private BlogConfigureMapper blogConfigureMapper;

    @Test
    public void insert(){
        BlogConfigure blogConfigure = new BlogConfigure("gonghf95","hello","123");
        blogConfigureMapper.insert(blogConfigure);
    }

    @Test
    public void insertSelective(){
        BlogConfigure blogConfigure = new BlogConfigure("gonghf95","hello","123");
        blogConfigureMapper.insertSelective(blogConfigure);
    }
}
