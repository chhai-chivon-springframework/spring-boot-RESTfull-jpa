package com.chhaichivon.springbootRESTfulljpa.service;

import com.chhaichivon.springbootRESTfulljpa.models.User;
import com.chhaichivon.springbootRESTfulljpa.repository.UserRepository;
import com.chhaichivon.springbootRESTfulljpa.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 1:13 PM
 */
@Service
public class UserService implements BaseService<User>{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Object findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void update(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }
}
