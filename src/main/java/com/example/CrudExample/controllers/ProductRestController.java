package com.example.CrudExample.controllers;

import com.example.CrudExample.entities.Product;
import com.example.CrudExample.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepository repository;

    @RequestMapping(value = "/products/", method= RequestMethod.GET )
    public List<Product> getProducts(){
        return repository.findAll();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProducts(@PathVariable("id") int id){
        return repository.findById(id).get();

    }

    @RequestMapping(value = "/products/", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product p){
        return repository.save(p);
    }

    @RequestMapping(value = "/products/", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product p){
        return repository.save(p);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") int id){
        repository.deleteById(id);
    }


}
