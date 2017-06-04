package cn.sumi.mapper;

import cn.sumi.po.Visitor;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);
}