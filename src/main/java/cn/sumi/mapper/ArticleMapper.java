package cn.sumi.mapper;

import cn.sumi.po.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer aid);

    List<Article> findAll();

    List<Article> findByType(int articleType);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}