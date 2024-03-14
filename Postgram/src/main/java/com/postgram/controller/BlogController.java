package com.postgram.controller;

import com.postgram.models.BlogModel;
import com.postgram.services.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
@AllArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/")
    public List<BlogModel> getAllBlogs() {
        return blogService.getAll();
    }

    @GetMapping("/:{id}")
    public Optional<BlogModel> getBlogById(@PathVariable Integer id) {
        return blogService.findById(id);
    }

    @PostMapping("/")
    public void create(@RequestBody BlogModel blogModel) {
        blogService.create(blogModel);
    }

    @PutMapping("/:{id}")
    public void update(@PathVariable Integer id, @RequestBody BlogModel blogModel) {
        blogModel.setId(id);
        blogService.update(blogModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        blogService.delete(id);
    }
}