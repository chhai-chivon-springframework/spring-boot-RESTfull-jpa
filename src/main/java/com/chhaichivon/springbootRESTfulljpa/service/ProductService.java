package com.chhaichivon.springbootRESTfulljpa.service;

import com.chhaichivon.springbootRESTfulljpa.models.Product;
import com.chhaichivon.springbootRESTfulljpa.repository.ProductRepository;
import com.chhaichivon.springbootRESTfulljpa.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 11:06 AM
 */
@Service
public class ProductService implements BaseService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Object findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public void update(Product entity) {
        productRepository.save(entity);
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }
}
