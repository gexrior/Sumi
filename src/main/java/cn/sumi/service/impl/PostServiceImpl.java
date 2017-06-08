package cn.sumi.service.impl;

import cn.sumi.mapper.ArticleMapper;
import cn.sumi.po.Article;
import cn.sumi.po.Comment;
import cn.sumi.service.PostService;
import cn.sumi.utils.Constants;
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
public class PostServiceImpl implements PostService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getArticleListByType(int articleType) {
        return articleMapper.findByType(articleType);
    }



    public int newPost(Article article, String author) throws DataAccessException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        article.setPublishDate(sdf.format(new Date()));
        article.setComments(0);
        article.setViews(0);
        article.setArticleType(article.getArticleType()==null?0:article.getArticleType());
        article.setAuthor(author);
        article.setDigest(extractDigest(article.getContents()));
        articleMapper.insert(article);
        return article.getAid();
    }

    public void updatePost(Article article) {
        articleMapper.updateByPrimaryKey(article);
    }

    public void updateFromOldPost(Article article) {
        Article old = find(article.getAid());
        old.setTitle(article.getTitle());
        old.setContents(article.getContents());
        old.setDigest(extractDigest(article.getContents()));
        old.setArticleType(article.getArticleType());
        articleMapper.updateByPrimaryKeyWithBLOBs(old);
    }

    public void editPost(Article articleId) {

    }

    public void delete(int articleId) {
        Article article = articleMapper.selectByPrimaryKey(articleId);
        article.setArticleType(Constants.ARTICLE_TYPE_DELETED);
        articleMapper.updateByPrimaryKey(article);
    }

    public void remove(int articleId) {
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
    private String extractDigest(String html){
        String digest = html.replaceAll("</?[^>]+>", "");
        digest = digest.replaceAll("\\s*|\t|\r|\n", "");
        int len = digest.length()>200?200:digest.length();
        return digest.substring(0,len);
    }
}
