package cn.sumi.mapper;

import cn.sumi.pojo.Feedback;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}