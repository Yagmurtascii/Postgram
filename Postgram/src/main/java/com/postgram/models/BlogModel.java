package com.postgram.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String details;
    String title;
    String tags;
    @ManyToMany
    @JoinTable(
            name = "blog_category", // Ara tablonun adı
            joinColumns = @JoinColumn(name = "blog_id"), // BlogModel tablosunun ID sütunu
            inverseJoinColumns = @JoinColumn(name = "category_id") // CategoryModel tablosunun ID sütunu
    )
    private List<CategoryModel> categories;
}
