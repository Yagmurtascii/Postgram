package com.postgram.services;

import com.postgram.models.CategoryModel;
import com.postgram.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    public List<CategoryModel> getAll()
    {
        return repository.findAll();
    }
    //Get - id
    public Optional<CategoryModel> getAllById(Integer id)
    {
        return repository.findById(id);
    }

    //Post
    public void create(CategoryModel categoryModel)
    {
        repository.save(categoryModel);
    }

    //Put
    public void update(CategoryModel categoryModel)
    {
        Optional<CategoryModel> existingBlogModel=repository.findById(categoryModel.getId());
        if(existingBlogModel.isPresent())
        {
            CategoryModel newBlogModel=existingBlogModel.get();
            newBlogModel.setCategoryName(categoryModel.getCategoryName());
            newBlogModel.setSubCategoryName(categoryModel.getSubCategoryName());

        }
    }
    //Delete
    public void delete(Integer id)
    {
        repository.deleteById(id);
    }

}
