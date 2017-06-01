package cn.sumi.service.impl;

import cn.sumi.mapper.ArticleMapper;
import cn.sumi.pojo.Article;
import cn.sumi.pojo.Comment;
import cn.sumi.pojo.User;
import cn.sumi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by gonghf95 on 5/24/17.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> findAll(User user) {
        return null;
    }

    public int newArticle(Article article, String author) throws DataAccessException {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        article.setPublishDate(new Date());
        article.setComments(0);
        article.setViews(0);
        article.setAuthor(author);
        articleMapper.insert(article);
        return article.getAid();
    }

    public void editArticle(Article articleId) {

    }

    public void deleteArticle(int articleId) {
        articleMapper.deleteByPrimaryKey(articleId);
    }

    public Article find(int articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    public void addComment(Comment comment) {

    }

    public void deleteCommentById(int cid) {

    }
}
