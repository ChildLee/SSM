package cn.service.Impl;

import cn.dao.CategoryDao;
import cn.entity.Category;
import cn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategory() {
        return categoryDao.getCategory();
    }

    @Override
    public List<Category> getCategoryLevel(int level) {
        return categoryDao.getCategoryLevel(level);
    }

    @Override
    public int setCategory(Category category) {
        return categoryDao.setCategory(category);
    }
}
