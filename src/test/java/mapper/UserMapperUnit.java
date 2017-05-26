package mapper;

import base.BaseConfiguration;
import cn.sumi.mapper.UserMapper;
import cn.sumi.pojo.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserMapper Test Unit
 * Created by gonghf95 on 5/25/17.
 */
public class UserMapperUnit extends BaseConfiguration{

    @Autowired
    private UserMapper userMapper;

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void find(){
        User u = new User();
        u.setAccount("jlk");
        User user = userMapper.find(u.getAccount());
        Assert.assertNull(user);
    }

    @Test
    public void save(){
        //User target = new User("admin","123");
        //userMapper.save(target);
    }

    @Test
    public void update(){
        //User target = new User("gonghf95","456");
        //userMapper.update(target);
    }

    @Test
    public void delete(){
        //User user = new User("gonghf95");
        //userMapper.delete(user);
    }

    @After
    public void after() {
        System.out.println("after");
    }
}
