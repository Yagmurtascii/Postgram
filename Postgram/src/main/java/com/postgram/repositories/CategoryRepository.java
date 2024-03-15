package com.postgram.repositories;

import com.postgram.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel,Integer> {
}
