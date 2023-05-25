package com.example.springbookdbexcersise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(25) not null")
    private String title;

    @Column(columnDefinition = "varchar(15) not null")
    private String author;

    //academic-mystery-novel
    @Column(columnDefinition = "varchar(15) not null check(category='academic' or category='mystery' or category='novel')")
    private String category;

    @Column(columnDefinition = "varchar(35) not null unique")
    private String isbn ;

    //50 min
    @Min(50)
    @Column(columnDefinition = "int default 50 check ( pagenum >= 50 )")
    private Integer pagenum ;





}
