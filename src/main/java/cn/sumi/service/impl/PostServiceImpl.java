package cn.sumi.service.impl;

import cn.sumi.mapper.PostMapper;
import cn.sumi.pojo.Comment;
import cn.sumi.pojo.Post;
import cn.sumi.pojo.User;
import cn.sumi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by gonghf95 on 5/24/17.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    public List<Post> getAll(User user) {
        return null;
    }

    public void newPost(Post post) throws DataAccessException {
        post.setPublishDate(new Date());
        post.setComments(0);
        post.setViews(0);
        postMapper.insert(post);
    }

    public void editPost(Post postId) {

    }

    public void deletePost(int postId) {

    }

    public void addComment(Comment comment) {

    }

    public void deleteCommentById(int cid) {

    }
}
