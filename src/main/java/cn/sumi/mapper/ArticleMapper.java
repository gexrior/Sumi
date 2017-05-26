package cn.sumi.mapper;

import cn.sumi.pojo.Article;
import org.springframework.stereotype.Repository;

/**
 *
 * Created by gonghf95 on 5/24/17.
 */
@Repository
public interface ArticleMapper {
    Article findById(int aid);
    Article findByName(String title);
    void save(Article article);
    void update(Article article);
    void delete(Article article);
}
