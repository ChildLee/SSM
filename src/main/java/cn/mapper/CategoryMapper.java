package cn.mapper;

import cn.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {

    /**
     * @return 所有分类
     */
    Category getCategory();

    /**
     * @return 所有对应等级分类
     */
    Category getCategoryLevel(String level);

    /**
     * @param category 需要添加的分类信息
     * @return 是否添加成功
     */
    int setCategory(Category category);
}
