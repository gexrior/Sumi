package cn.sumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 评论控制层
 * Created by gonghf95 on 5/26/17.
 */
@Controller
public class FeedbackController {

    /**
     * 评论管理
     *
     * @author gonghf95
     */
    @RequestMapping("/feedback")
    public String feedback(Model model) {
        return "feedback";
    }
}
