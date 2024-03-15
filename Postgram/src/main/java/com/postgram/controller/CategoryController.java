package com.postgram.controller;

import com.postgram.models.BlogModel;
import com.postgram.models.CategoryModel;
import com.postgram.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/")
    public List<CategoryModel> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/:{id}")
    public Optional<CategoryModel> getAllById(@PathVariable Integer id)
    {
        return service.getAllById(id);
    }

    @PostMapping("/")
    public void create(@RequestBody CategoryModel categoryModel)
    {
        service.create(categoryModel);
    }


    @PutMapping("/:{id}")
    public void update(@PathVariable Integer id, @RequestBody CategoryModel categoryModel) {
        categoryModel.setId(id);
        service.update(categoryModel);
    }

    @DeleteMapping("/:{id}")
    public void delete(Integer id)
    {
        service.delete(id);
    }
}
