package com.chhaichivon.springbootRESTfulljpa.repository;

import com.chhaichivon.springbootRESTfulljpa.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 3:53 PM
 */
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
