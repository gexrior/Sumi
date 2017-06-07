package cn.sumi.service;

import cn.sumi.po.Article;
import cn.sumi.po.Comment;

import java.util.List;

/**
 * 文章业务
 * Created by gonghf95 on 5/24/17.
 */
public interface PostService {

    /**
     * 获取用户的文章列表
     */
    List<Article> getArticleListByType(int articleType);

    /**
     * 添加新文章
     *
     * @param article 待添加文章
     * @return 插入后的id
     */
    int newArticle(Article article, String author);

    /**
     * 更新文章
     * @param article 记录
     * */
    void updateArticle(Article article);

    /**
     * 编辑文章
     *
     * @param articleId 待编辑的文章
     */
    void editArticle(Article articleId);

    /**
     * 删除文章
     *
     * @param articleId 待删除文章Id
     */
    void delete(int articleId);

    /**
     * 移除该文章
     * @param articleId 删除文章
     * */
    void remove(int articleId);

    /**
     * 文章详情
     *
     * @param articleId 文章id
     * @author gonghf95
     */
    Article find(int articleId);

    /**
     * 添加评论
     *
     * @param comment 评论
     */
    void addComment(Comment comment);

    /**
     * 删除评论
     *
     * @param cid 评论id
     * @author gonghf95
     */
    void deleteCommentById(int cid);
}
