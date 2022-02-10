package com.educative.ecommerce.controllers;

import com.educative.ecommerce.common.ApiResponse;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category){
        if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category already exists!"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "Category created!"), HttpStatus.CREATED);

    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") Integer categoryId, @Valid @RequestBody Category category){
        // Verifica se a categoria já existe
        if (Objects.nonNull(categoryService.readCategory(categoryId))){
            // Se a categoria existir, realiza a atualização
            categoryService.updateCategory(categoryId, category);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Category updated!"), HttpStatus.OK);
        }
        // Se a categoria não existir, é retornada uma mensagem de falha
        return new ResponseEntity<>(new ApiResponse(false, "Category doesn't exists"), HttpStatus.NOT_FOUND);

    }



}
