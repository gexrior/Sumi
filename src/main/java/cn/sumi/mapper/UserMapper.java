package cn.sumi.mapper;

import cn.sumi.pojo.User;
import org.springframework.stereotype.Repository;

/**
 *  User Data Access Object
 * Created by gonghf95 on 5/24/17.
 */
@Repository
public interface UserMapper {
    User find(String account);
    void save(User user);
    void update(User user);
    void delete(User user);
}
