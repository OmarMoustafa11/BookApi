package com.JiveTurkey.JiveTurkeyProject.controller;

import com.JiveTurkey.JiveTurkeyProject.domain.Category;
import com.JiveTurkey.JiveTurkeyProject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategorys() {
        return categoryService.getAllCategorys();
    }

    @PostMapping("/category")            //Valid
    public void createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        return categoryService.updateCategory(category,categoryId);
    }

    @DeleteMapping("/category/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);

}}
