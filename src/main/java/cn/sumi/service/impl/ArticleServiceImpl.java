package cn.sumi.service.impl;

import cn.sumi.pojo.Article;
import cn.sumi.pojo.Feedback;
import cn.sumi.pojo.User;
import cn.sumi.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by gonghf95 on 5/24/17.
 */
@Service
public class ArticleServiceImpl implements ArticleService{


    public List<Article> getAll(User user) {
        return null;
    }

    public void newArticle(Article article) {

    }

    public void editArticle(Article article) {

    }

    public void deleteArticle(int articleId) {

    }

    public void addFeedback(Feedback feedback) {

    }

    public void deleteFeedbackById(int fid) {

    }
}
