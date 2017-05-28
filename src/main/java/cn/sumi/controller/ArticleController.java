package cn.sumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文章控制层
 * Created by gonghf95 on 5/24/17.
 */
@Controller("/article")
public class ArticleController {

    /**
     * 删除文章
     *
     * @param aid 文章id
     * @author gonghf95
     */
    @RequestMapping("/delete/{aid}")
    public String delete(@RequestParam int aid){
        return null;
    }

    /**
     * 文章详情
     *
     * @param aid 文章id
     * @author gonghf95
     */
    @RequestMapping("/details/{aid}")
    public ModelAndView details(int aid) {

        return null;
    }
}
