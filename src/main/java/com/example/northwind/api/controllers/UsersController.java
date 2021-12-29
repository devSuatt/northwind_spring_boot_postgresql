package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.UserService;
import com.example.northwind.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    // işlemin başarılı olup olmadığını henüz bilmediğimiz için ? koyuyoruz.
    // ResponseEntity burada status kodu olarak 200 de dönebilir, 500 de dönebilir.
    public ResponseEntity<?> add(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user));
    }



}
