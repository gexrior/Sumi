package cn.sumi.service;

import cn.sumi.pojo.Article;
import cn.sumi.pojo.Feedback;
import cn.sumi.pojo.User;

import java.util.List;

/**
 * 文章业务
 * Created by gonghf95 on 5/24/17.
 */
public interface ArticleService {
    /**
     * 获取用户的文章列表
     *
     * @param user 待查找用户
     */
    List<Article> findAll(User user);

    /**
     * 添加新文章
     *
     * @param article 待添加文章
     */
    void newArticle(Article article);

    /**
     * 编辑文章
     *
     * @param article 待编辑的文章
     */
    void edit(Article article);

    /**
     * 删除文章
     *
     * @param articleId 待删除文章Id
     */
    void delete(int articleId);


    /**
     * 添加评论
     *
     * @param feedback 评论
     */
    void addFeedback(Feedback feedback);

    void deleteFeedbackById(int fid);
}
