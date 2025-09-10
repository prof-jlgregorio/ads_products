package br.com.jlgregorio.Products.service;

import br.com.jlgregorio.Products.exceptions.ResourceNotFoundException;
import br.com.jlgregorio.Products.model.CategoryModel;
import br.com.jlgregorio.Products.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryModel create(CategoryModel categoryModel){
        return categoryRepository.save(categoryModel);
    }

    public CategoryModel findById(long id){
        CategoryModel found = categoryRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException("Categoria não encontrada!"));
        return found;
    }

    public List<CategoryModel> findAll(){
        return categoryRepository.findAll();
    }

    public List<CategoryModel> findByName(String name){
        return categoryRepository.findByNameContainsIgnoreCase(name);
    }

    public CategoryModel update(CategoryModel categoryModel){
        var found = categoryRepository.findById(categoryModel.getId())
                .orElseThrow( ()-> new ResourceNotFoundException(
                        "Categoria não encontrada!"));
        found.setName(categoryModel.getName());
        return categoryRepository.save(found);
    }

    public void delete(long id){
        var found = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoria não encontrada!"));
        categoryRepository.delete(found);
    }

}
