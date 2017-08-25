package com.chhaichivon.springbootRESTfulljpa.controller;

import com.chhaichivon.springbootRESTfulljpa.form.UserForm;
import com.chhaichivon.springbootRESTfulljpa.models.User;
import com.chhaichivon.springbootRESTfulljpa.service.UserService;
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
@Api(basePath = "/api", value = "Users", description = "Operations with users", produces = "application/json")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;
    public Map<String, Object> map;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findAll() {
        map = new HashMap<>();
        List<User> users = null;
        try {
            users = (List<User>) userService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error" + e.getMessage());
        }
        return responseJson(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        User user = null;
        try {
            user = userService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user, HttpStatus.OK);
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody UserForm userForm) {
        map = new HashMap<>();
        User user = new User();
        try {
            if (userForm != null) {
                user.setUsername(userForm.getUserName());
                user.setEmail(userForm.getEmail());
                user.setPassword(userForm.getPassword());
            }
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> update(@RequestBody User userUpdate) {
        map = new HashMap<>();
        try {
            if (userUpdate != null) {
                userService.update(userUpdate);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return responseJson(userUpdate, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") long id) {
        map = new HashMap<>();
        User user = userService.findById(id);
        try {
            if (user != null) {
                userService.delete(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user, HttpStatus.OK);
    }
}