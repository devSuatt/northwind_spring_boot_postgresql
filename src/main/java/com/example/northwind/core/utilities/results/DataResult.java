package com.example.northwind.core.utilities.results;

// Buradaki data herhangi bir veri tipi olabilir: Employee, Product, User, Category...
// Birden fazla veri tipi ile çalışabileceğimiz için veri tipini Generic olarak belirtiyoruz.
public class DataResult<T> extends Result {

    private T data;

    public DataResult(T data, boolean success, String messsage) {
        super(success, messsage); // buradaki super anahtar kelimesi, base class'ın (Result)
        // constructor'larını çalıştırmayı sağlar. DataResults nesnesi ile gelen
        // success ve message bilgilerini base class'a göndermiş oluruz.
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

}
