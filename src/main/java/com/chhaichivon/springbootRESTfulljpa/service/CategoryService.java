package com.chhaichivon.springbootRESTfulljpa.service;

import com.chhaichivon.springbootRESTfulljpa.models.Category;
import com.chhaichivon.springbootRESTfulljpa.repository.CategoryRepository;
import com.chhaichivon.springbootRESTfulljpa.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 3:53 PM
 */
@Service
public class CategoryService implements BaseService<Category> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Object findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public void update(Category entity) {
        categoryRepository.save(entity);
    }

    @Override
    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }
}
