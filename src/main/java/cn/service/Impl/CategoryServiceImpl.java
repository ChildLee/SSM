package cn.service.Impl;

import cn.entity.Category;
import cn.mapper.CategoryMapper;
import cn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategory() {
        return categoryMapper.getCategory();
    }

    @Override
    public List<Category> getCategoryLevel(int level) {
        return categoryMapper.getCategoryLevel(level);
    }

    @Override
    public int setCategory(Category category) {
        return categoryMapper.setCategory(category);
    }
}
