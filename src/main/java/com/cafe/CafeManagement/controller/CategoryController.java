package com.cafe.CafeManagement.controller;

import com.cafe.CafeManagement.dto.CategoryDTO;
import com.cafe.CafeManagement.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping()
    public CategoryDTO create(@RequestBody CategoryDTO model) {
        return categoryService.create(model);
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@RequestBody CategoryDTO model, @PathVariable Long id) {
        return categoryService.update(model, id);
    }

    @DeleteMapping("/{id}")
    public CategoryDTO del(@PathVariable Long id) {
        return categoryService.del(id);
    }
}
