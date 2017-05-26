package cn.sumi.controller;

import cn.sumi.utils.Model;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文章控制层
 * Created by 龚洪富 on 5/24/17.
 */
@Controller("/article")
public class ArticleController {

    /**
     * 删除文章
     *
     * @param aid 文章id
     * @author 龚洪富
     */
    @RequestMapping("/delete/{aid}")
    public @ResponseBody
    Model delete(@RequestParam int aid) {
        return null;
    }

    /**
     * 文章详情
     *
     * @param aid 文章id
     * @author 龚洪富
     */
    @RequestMapping("/details/{aid}")
    public @ResponseBody
    Model details(int aid) {

        return null;
    }
}
