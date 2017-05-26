package cn.sumi.controller;

import cn.sumi.utils.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 评论控制层
 * Created by 龚洪富 on 5/26/17.
 */
@RequestMapping
public class FeedbackController {

    /**
     * 评论管理
     * @author 龚洪富
     */
    @RequestMapping("/feedback")
    public @ResponseBody
    Model feedback() {
        return null;
    }
}
