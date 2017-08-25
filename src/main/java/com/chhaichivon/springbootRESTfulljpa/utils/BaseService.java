package com.chhaichivon.springbootRESTfulljpa.utils;

import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 11:07 AM
 */
public interface BaseService<T> extends Serializable {
    Object findAll();
    T findById(long id);
    T save(T entity);
    void update(T entity);
    void delete(T entity);
}
