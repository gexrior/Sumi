import base.BaseConfiguration;
import cn.sumi.pojo.User;
import cn.sumi.service.UserService;
import cn.sumi.utils.Constants;
import cn.sumi.utils.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User Service Test
 * Created by gonghf95 on 5/25/17.
 */
public class UserServiceUnit extends BaseConfiguration{

    private User notExistObj;
    @Autowired
    private UserService userService;

    @Before
    public void init(){
        notExistObj = new User();
        notExistObj.setAccount("null");
    }

    @Test
    public void login(){

        Model model =  userService.login(notExistObj);
        Assert.assertEquals(model, Constants.ACCOUNT_NOT_EXIST);

    }
}
