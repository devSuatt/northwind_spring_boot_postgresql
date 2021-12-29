package com.example.northwind.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {

    private int id;

    private String productName;

    private String categoryName;

}
