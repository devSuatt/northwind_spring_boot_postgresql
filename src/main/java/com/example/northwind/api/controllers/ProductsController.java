package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    //@Autowired anotasyonunu direk buraya yazdığımızda constructor oluşturmamıza gerek kalmayacaktı,
    // ama her instance oluşturduğumuzda her biri için teker teker constructor injection yapmamak için
    // constructor oluşturup bir kere @Autowired anotasyonunu kullanıyoruz.
    private ProductService productService;

    @Autowired
    // autowired kullandığımızda parametre olan productService'i, projeyi tarayıp
    // ProductService interface'ini hangi class'ın implemente ettiğini bularak bizim yerimize o class'ın
    // arka planda new ile instance'ini oluşturuyor.
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired

    @GetMapping("")
    public String products() {
        return "PRODUCTS PAGE";
    }

    @GetMapping("/getall")
    public List<Product> getAll() {
        return this.productService.getAll();
    }

}
