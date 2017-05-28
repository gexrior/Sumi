package cn.sumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类别控制层
 * Created by gonghf95 on 5/25/17.
 */
@Controller
public class CategoryController {

    /**
     * 添加类别
     *
     * @param category 类别名
     * @author gonghf95
     */
    @RequestMapping("/category/add")
    public String add(Model model, String category) {
        return null;
    }

    /**
     * 获取类别栏目
     *
     * @author gonghf95
     */
    @RequestMapping("/category")
    public String category(Model model) {

        return null;
    }
}
