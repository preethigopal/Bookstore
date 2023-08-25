package com.example.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "mybook")
public class MyBookList {
    
    @Id
    private Integer id;
    private String name;
    private String author;
    private String price;

     public MyBookList(Integer id, String name, String author, String price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public MyBookList() {
        super();
    }
}
