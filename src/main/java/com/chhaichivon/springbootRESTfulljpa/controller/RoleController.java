package com.chhaichivon.springbootRESTfulljpa.controller;

import com.chhaichivon.springbootRESTfulljpa.form.RoleForm;
import com.chhaichivon.springbootRESTfulljpa.models.Role;
import com.chhaichivon.springbootRESTfulljpa.service.RoleService;
import com.chhaichivon.springbootRESTfulljpa.utils.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 1:18 PM
 */

@RestController
@Api(basePath = "/api", value = "Roles", description = "Operations with role", produces = "application/json")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController extends BaseController<Role> {

    @Autowired
    private RoleService roleService;
    public Map<String, Object> map;

    @RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findAll(){
        map = new HashMap<>();
        List<Role> roles= null;
        try {
            roles = (List<Role>) roleService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error" + e.getMessage());
        }
        return responseJson(roles, HttpStatus.OK);
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        Role role = null;
        try {
            role = roleService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(role,HttpStatus.OK);
    }


    @RequestMapping(value = "/roles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody RoleForm roleForm) {
        map = new HashMap<>();
        Role role = new Role();
        try {
            if(roleForm != null){
                role.setName(roleForm.getRoleName());
                role.setDescription(roleForm.getDescription());
            }
            roleService.save(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(role,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> update(@RequestBody Role roleUpdate){
        map = new HashMap<>();
        try {
            if(roleUpdate !=  null){
                roleService.update(roleUpdate);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return responseJson(roleUpdate,HttpStatus.OK);
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") long id) {
        map = new HashMap<>();
        Role role = roleService.findById(id);
        try {
            if (role != null) {
                roleService.delete(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(role, HttpStatus.OK);
    }
}