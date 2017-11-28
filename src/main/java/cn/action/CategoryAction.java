package cn.action;

import cn.entity.Category;
import cn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryAction {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/getCategory", method = RequestMethod.GET)
    public List<Category> getCategory(Integer level) {
        if (null == level) {
            return categoryService.getCategory();
        }
        return categoryService.getCategoryLevel(level);
    }

    @RequestMapping(value = "/setCategory", method = RequestMethod.GET)
    public int setCategory(Category category) {
        return categoryService.setCategory(category);
    }
}
