package cn.sumi.service;

import cn.sumi.pojo.Comment;
import cn.sumi.pojo.Post;
import cn.sumi.pojo.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 文章业务
 * Created by gonghf95 on 5/24/17.
 */
public interface PostService {

    /**
     * 获取用户的文章列表
     *
     * @param user 待查找用户
     */
    List<Post> findAll(User user);

    /**
     * 添加新文章
     *
     * @param post 待添加文章
     * @return 插入后的id
     */
    int newPost(Post post, String author);

    /**
     * 编辑文章
     *
     * @param postId 待编辑的文章
     */
    void editPost(Post postId);

    /**
     * 删除文章
     *
     * @param postId 待删除文章Id
     */
    void deletePost(int postId);


    /**
     * 文章详情
     *
     * @param postId 文章id
     * @author gonghf95
     */
    Post find(int postId);

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
