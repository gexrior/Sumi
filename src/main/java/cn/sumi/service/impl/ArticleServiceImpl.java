package cn.sumi.service.impl;

import cn.sumi.mapper.ArticleMapper;
import cn.sumi.po.Article;
import cn.sumi.po.Comment;
import cn.sumi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    public int newArticle(Article article, String author) throws DataAccessException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        article.setPublishDate(sdf.format(new Date()));
        article.setComments(0);
        article.setViews(0);
        article.setAuthor(author);
        article.setDigest(extractDigest(article.getContents()));
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

    /**
     * 提取html中前200个字作为摘要
     * */
    public String extractDigest(String html){
        String digest = html.replaceAll("</?[^>]+>", "");
        digest = digest.replaceAll("\\s*|\t|\r|\n", "");
        digest = digest.replaceAll("&nbsp;","");
        int len = digest.length()>200?200:digest.length();
        return digest.substring(0,len);
    }
}
