package com.chhaichivon.springbootRESTfulljpa.repository;

import com.chhaichivon.springbootRESTfulljpa.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 1:12 PM
 */
@Repository
public interface RoleRepository extends CrudRepository<Role,Long>{
}
