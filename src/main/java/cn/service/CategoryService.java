package cn.service;

import cn.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    /**
     * @return 所有分类
     */
    List<Category> getCategory();

    /**
     * @return 所有对应等级分类
     */
    List<Category> getCategoryLevel(int level);

    /**
     * @param category 需要添加的分类信息
     * @return 是否添加成功
     */
    int setCategory(Category category);
}
