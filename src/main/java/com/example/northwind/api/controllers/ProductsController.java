package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("/add")
    // @RequestBody anotasyonu, url body'sinden gelen product bilgisini arka planda
    // entity katmanındaki product nesnesinin alanlarına map eder ve bir product nesnesine dönüştürür.
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product>
    getByProductNameAndCategoryId(
            @RequestParam("productName") String productName,
            @RequestParam("categoryId") int categoryId) {
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted(@RequestParam("sortType") String sortType) {
        return this.productService.getAllSorted(sortType);
    }

}
