package com.postgram.repositories;

import com.postgram.models.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<BlogModel, Integer> {
    //save, update, delete, get
    List<BlogModel> findAll();

}
