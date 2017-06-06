package mapper;

import base.BaseConfiguration;
import cn.sumi.mapper.ArticleMapper;
import cn.sumi.po.Article;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gonghf95 on 5/31/17.
 */
public class ArticleMapperUnint extends BaseConfiguration {

    Logger logger = Logger.getLogger(ArticleMapperUnint.class);
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void findAll() {
        List<Article> articleList = articleMapper.findAll();
        for (Article article : articleList) {
            logger.info(article);
        }
    }

    @Test
    public void findByType() {
        List<Article> articles = articleMapper.findByType(Article.TYPE_NORMAL);
        for (Article article : articles) {
            logger.info(article);
        }
    }

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {

    }

    @Test
    public void insertSelective() {

    }

    @Test
    public void selectByPrimaryKey() {

    }

    @Test
    public void updateByPrimaryKeySelective() {

    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() {

    }

    @Test
    public void updateByPrimaryKey() {

    }
}
