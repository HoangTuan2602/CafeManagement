package com.cafe.CafeManagement.service.impl;

import com.cafe.CafeManagement.dto.CategoryDTO;
import com.cafe.CafeManagement.entity.Category;
import com.cafe.CafeManagement.exception.InvalidRequestException;
import com.cafe.CafeManagement.repository.CategoryRepository;
import com.cafe.CafeManagement.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryRepository.findAll().stream().forEach(category -> categoryDTOList.add(new CategoryDTO(category)));
        return categoryDTOList;
    }

    @Override
    public CategoryDTO findById(long id) {
        boolean exists = categoryRepository.existsById(id);
        if (exists) {
            Optional<Category> category = categoryRepository.findById(id);
            return new CategoryDTO(category.get());
        }
        return null;
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        if (categoryDTO.isNull()) {
            throw new InvalidRequestException("Invalid request. Please check again!");
        }

        Category category = Category.builder()
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .build();
        return new CategoryDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO, long id) {
        if (categoryDTO.isNull())
        {
            throw new InvalidRequestException("Invalid request. Please check again!");
        }
        Category updateCategory = categoryRepository.findById(id)
                .map(category -> {
                    category.setName(categoryDTO.getName());
                    category.setDescription(categoryDTO.getDescription());
                    return categoryRepository.save(category);
                }).orElseGet(() -> {
                    categoryDTO.setId(id);
                    return categoryRepository.save(Category.builder()
                            .id(categoryDTO.getId())
                            .name(categoryDTO.getName())
                            .description((categoryDTO.getDescription()))
                            .build());
                });
        return new CategoryDTO(updateCategory);
    }

    @Override
    public CategoryDTO del(long id) {
        boolean exists = categoryRepository.existsById(id);
        if (exists) {
            Optional<Category> deleteCategory = categoryRepository.findById(id);
            categoryRepository.deleteById(id);
            return new CategoryDTO(deleteCategory.get());
        }
        return null;
    }
}
