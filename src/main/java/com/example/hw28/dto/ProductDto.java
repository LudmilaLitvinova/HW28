package com.example.hw28.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ludmila Litvinova on 25.01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;

    private String name;

    private Integer cost;

}
