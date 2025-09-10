package br.com.jlgregorio.Products.controller;

import br.com.jlgregorio.Products.model.CategoryModel;
import br.com.jlgregorio.Products.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryModel>> findAll(){
        List<CategoryModel> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryModel> create(@RequestBody CategoryModel categoryModel){
        CategoryModel created = categoryService.create(categoryModel);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> findById(@PathVariable("id") long id){
        CategoryModel found = categoryService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CategoryModel> update(@RequestBody CategoryModel categoryModel){
        var updated = categoryService.update(categoryModel);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        categoryService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }




}
