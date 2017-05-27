package mapper;

import base.BaseConfiguration;
import cn.sumi.mapper.BlogConfigureMapper;
import cn.sumi.pojo.BlogConfigure;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
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
        //This guys NOT EXIST
        BlogConfigure configure1 = new BlogConfigure(1,"gonghf95","a simple blog");
        blogConfigureMapper.add(configure1);

        //insert a normal user's configuration
        BlogConfigure blogConfigure2 = new BlogConfigure(2,"gonghf95","a simple blog");
        blogConfigureMapper.add(blogConfigure2);
    }

    @Test
    public void find(){
        //
        BlogConfigure res1 = blogConfigureMapper.find(1111);//not exist
        Assert.assertNull(res1);
        BlogConfigure res2 = blogConfigureMapper.find(2);//exist
        Assert.assertNotNull(res2);
        logger.info(res2);
    }
}
