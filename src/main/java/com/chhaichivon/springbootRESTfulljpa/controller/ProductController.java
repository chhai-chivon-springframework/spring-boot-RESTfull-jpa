package com.chhaichivon.springbootRESTfulljpa.controller;

import com.chhaichivon.springbootRESTfulljpa.form.ProductForm;
import com.chhaichivon.springbootRESTfulljpa.models.Product;
import com.chhaichivon.springbootRESTfulljpa.service.ProductService;
import com.chhaichivon.springbootRESTfulljpa.utils.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * TIME   : 9:27 AM
 */
@RestController
@Api(basePath = "/api", value = "Products", description = "Operations with products", produces = "application/json")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController extends BaseController<Product>{

    @Autowired
    private ProductService productService;
    public Map<String, Object> map;

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findAll(){
        map = new HashMap<>();
        List<Product> products= null;
        try {
            products = (List<Product>) productService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error" + e.getMessage());
        }
        return responseJson(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        Product  product = null;
        try {
            product = productService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product,HttpStatus.OK);
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody ProductForm productForm) {
        map = new HashMap<>();
        Product product = new Product();
        try {
            if(productForm != null){
                product.setName(productForm.getName());
                product.setDescription(productForm.getDescription());
            }
            productService.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> update(@RequestBody Product productUpdate){
        map = new HashMap<>();
        try {
            if(productUpdate !=  null){
                productService.update(productUpdate);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return responseJson(productUpdate,HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") long id) {
        map = new HashMap<>();
        Product product = productService.findById(id);
        try {
            if (product != null) {
                productService.delete(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product, HttpStatus.OK);
    }
}
