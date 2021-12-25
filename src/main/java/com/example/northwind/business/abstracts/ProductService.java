package com.example.northwind.business.abstracts;

import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;
import java.util.List;

public interface ProductService {
    // getAll metodunun tipi List<Product> olmaması gerekir çünkü işlemin başarılı olup olmadığını bilemeyiz.
    // Bunun yerine işlem sonucunu da tutabilmek için DataResults tipinde bir nesne döneriz.
    DataResult<List<Product>> getAll();
    Result add(Product product);
}
