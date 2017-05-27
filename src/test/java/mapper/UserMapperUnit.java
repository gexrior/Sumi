package mapper;

import base.BaseConfiguration;
import cn.sumi.mapper.UserMapper;
import cn.sumi.pojo.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserMapper Test Unit
 * Created by gonghf95 on 5/25/17.
 */
public class UserMapperUnit extends BaseConfiguration {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() {
        User user1 = userMapper.selectByPrimaryKey("gonghf95");
        Assert.assertNull(user1);

    }


    @Test
    public void insert() {
        User user = new User();
        user.setAccount("gonghf95");
        user.setPasswd("123");
        userMapper.insert(user);
    }

    @Test
    public void deleteByPrimaryKey() {
        userMapper.deleteByPrimaryKey("gonghf95");
    }

    @Test
    public void updateByPrimaryKeySelective() {
        User target = new User();
        target.setAccount("gonghf95");
        target.setPasswd("888");
        userMapper.updateByPrimaryKeySelective(target);
    }

    @Test
    public void updateByPrimaryKey() {
        User user = new User();
        user.setAccount("gonghf95");
        user.setEmail("gonghf95@gmail.com");
        userMapper.updateByPrimaryKey(user);
    }

    @After
    public void after() {
        System.out.println("after");
    }
}
