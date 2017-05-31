package mapper;

import base.BaseConfiguration;
import cn.sumi.mapper.PostMapper;
import cn.sumi.pojo.Post;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by gonghf95 on 5/31/17.
 */
public class PostMapperUnint extends BaseConfiguration {

    @Autowired
    private PostMapper postMapper;


    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
        Post post = new Post();
        post.setAuthor("gonghf95");
        post.setTitle("title");
        post.setContents("contents");
        post.setPublishDate(new Date());
        postMapper.insert(post);

        //post.setAuthor("NotExistAccount");
        //postMapper.insert(post);
    }

    @Test
    public void insertSelective() {
        Post post = new Post();
        post.setAuthor("gonghf95");
        post.setTitle("title");
        post.setContents("contents");
        post.setPublishDate(new Date());
        postMapper.insert(post);
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
