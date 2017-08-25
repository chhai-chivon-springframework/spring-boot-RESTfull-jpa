package com.chhaichivon.springbootRESTfulljpa.service;

import com.chhaichivon.springbootRESTfulljpa.models.Role;
import com.chhaichivon.springbootRESTfulljpa.repository.RoleRepository;
import com.chhaichivon.springbootRESTfulljpa.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 1:14 PM
 */
@Service
public class RoleService implements BaseService<Role>{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Object findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void update(Role entity) {
        roleRepository.save(entity);
    }

    @Override
    public void delete(Role entity) {
        roleRepository.delete(entity);
    }
}
