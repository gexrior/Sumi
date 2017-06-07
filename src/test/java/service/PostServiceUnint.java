package service;

import base.BaseConfiguration;
import cn.sumi.service.PostService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gonghf95 on 5/31/17.
 */
public class PostServiceUnint extends BaseConfiguration{

    Logger logger = Logger.getLogger(PostServiceUnint.class);

    @Autowired
    private PostService postService;


    @Test
    public void extractDigest(){
        String html="又一年过去了，这一次的总结，有点惭愧。2014，是我浮躁的一年。&nbsp;&nbsp;&nbsp;&nbsp;昨晚看完了《废柴联盟》最后一集，我觉得，我就像里面的废柴们一样，活在一个自己骗自己的世界里。感觉有很多雄心壮志，但是落到实处就焉了。剧里他们的生活挺美好，但是他们追求的目标跟我是不一样的。他们开开心心就好了，没有那么大的压力，很羡慕他们的心态，剧就是剧，人生是人生。&nbsp;&nbsp";
        String digest = extractDigest(html);
        logger.info(digest);
    }

    @Test
    public void findAll(){

    }

    public String extractDigest(String html){
        String digest = html.replaceAll("</?[^>]+>", "");
        digest = digest.replaceAll("\\s*|\t|\r|\n", "");
        digest = digest.replaceAll("&nbsp;","");
        int len = digest.length()>200?200:digest.length();
        return digest.substring(0,len);
    }
}
