package com.chhaichivon.springbootRESTfulljpa.repository;

import com.chhaichivon.springbootRESTfulljpa.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 9:25 AM
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {

}
