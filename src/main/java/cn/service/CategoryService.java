package cn.service;

import cn.entity.Category;
import cn.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public Category getCategory() {
        return null;
    }
}
