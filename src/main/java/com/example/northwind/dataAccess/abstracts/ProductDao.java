package com.example.northwind.dataAccess.abstracts;

import com.example.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    Product getByProductName(String productName);
    // // SELECT * FROM products WHERE product_name = xxx

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    // Burada getBy keyword'ünü gördüğü anda otomatikmen bir sql sorgusu çalışıyor,
    // iki alan arasındaki And kelimesine göre de içinde and operatörü olan bir
    // where sql sorgusu çalışıyor. (SELECT ... WHERE X AND Y)

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    // SELECT * FROM products WHERE product_name = xxx AND CATEGORY_ID = 1

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
    // SELECT * FROM products WHERE category_id in(1,2,3,4)

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    // JPQL kullanımı ile kendi metotlarımızı yazabiliriz.
    @Query("From Product where productName=:productName and categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

}
