package mapper;

import base.BaseConfiguration;
import cn.sumi.mapper.BlogConfigureMapper;
import cn.sumi.pojo.BlogConfigure;
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
    }

    @Test
    public void find(){

    }
}
