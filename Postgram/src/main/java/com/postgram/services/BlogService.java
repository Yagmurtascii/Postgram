package com.postgram.services;

import com.postgram.models.BlogModel;
import com.postgram.repositories.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    //GEt
    public List<BlogModel> getAll()
    {
        return blogRepository.findAll();
    }
    //Get -id
    public Optional<BlogModel> findById(Integer id)
    {
        return blogRepository.findById(id);
    }
    //delete
    public void delete(Integer id)
    {
        blogRepository.deleteById(id);
    }

    //create
    public void create(BlogModel blogModel)
    {
        blogRepository.save(blogModel);
    }

    //update
    public void update(BlogModel blogModel)
    {
        Optional<BlogModel> existingBlogModel=blogRepository.findById(blogModel.getId());
        if(existingBlogModel.isPresent())
        {
            BlogModel newBlogModel=existingBlogModel.get();
            newBlogModel.setDetails(blogModel.getDetails());
            newBlogModel.setTitle(blogModel.getTitle());
            newBlogModel.setTags(blogModel.getTags());
        }
    }
}