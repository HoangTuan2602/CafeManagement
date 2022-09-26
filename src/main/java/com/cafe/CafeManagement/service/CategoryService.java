package com.cafe.CafeManagement.service;

import com.cafe.CafeManagement.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO create(CategoryDTO categoryDTO);

    CategoryDTO update(CategoryDTO categoryDTO, long id);

    CategoryDTO del(long id);

    List<CategoryDTO> getAllCategories();

    CategoryDTO findById(long id);
}
