package com.JiveTurkey.JiveTurkeyProject.service;

import com.JiveTurkey.JiveTurkeyProject.Repository.CategoryRepository;
import com.JiveTurkey.JiveTurkeyProject.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<Iterable<Category>> getAllCategorys (){
        Iterable<Category> allCategory = categoryRepository.findAll();

        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }
    public void createCategory(Category category) {
        categoryRepository.save(category);

    }

    public ResponseEntity<?> getCategoryById(Long categoryId) {

        Optional<Category> c = categoryRepository.findById(categoryId);
        return new ResponseEntity<> (c, HttpStatus.OK);
    }


    public ResponseEntity<?> updateCategory(Category category, Long categoryId) {

        categoryRepository.save(category);

        return new ResponseEntity<> (HttpStatus.OK);
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }






}
