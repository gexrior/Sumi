package cn.sumi.mapper;

import cn.sumi.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String account);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String account);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}