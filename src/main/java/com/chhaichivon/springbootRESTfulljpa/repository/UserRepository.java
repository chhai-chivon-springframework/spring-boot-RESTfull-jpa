package com.chhaichivon.springbootRESTfulljpa.repository;

import com.chhaichivon.springbootRESTfulljpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 1:12 PM
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
