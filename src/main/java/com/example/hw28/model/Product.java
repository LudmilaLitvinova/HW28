package com.example.hw28.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ludmila Litvinova on 25.01
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "my_store")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer cost;

}
