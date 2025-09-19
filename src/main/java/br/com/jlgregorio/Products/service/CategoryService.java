package br.com.jlgregorio.Products.service;

import br.com.jlgregorio.Products.dto.CategoryDto;
import br.com.jlgregorio.Products.exceptions.ResourceNotFoundException;
import br.com.jlgregorio.Products.mapper.CustomModelMapper;
import br.com.jlgregorio.Products.model.CategoryModel;
import br.com.jlgregorio.Products.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto create(CategoryDto categoryDto){
        CategoryModel categoryModel = CustomModelMapper.parseObject(
                categoryDto, CategoryModel.class);
        var result = categoryRepository.save(categoryModel);
        return CustomModelMapper.parseObject(result, CategoryDto.class);
    }

    public CategoryDto findById(long id){
        CategoryModel found = categoryRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException("Categoria não encontrada!"));
        return CustomModelMapper.parseObject(found, CategoryDto.class);
    }

    public List<CategoryDto> findAll(){
        var categories = categoryRepository.findAll();
        return CustomModelMapper.parseObjectList(categories, CategoryDto.class);
    }

    public List<CategoryDto> findByName(String name){
        var categories = categoryRepository.findByNameContainsIgnoreCase(name);
        return CustomModelMapper.parseObjectList(categories, CategoryDto.class);
    }

    public CategoryDto update(CategoryDto categoryDto){
        var found = categoryRepository.findById(categoryDto.getId())
                .orElseThrow( ()-> new ResourceNotFoundException(
                        "Categoria não encontrada!"));
        found.setName(categoryDto.getName());
        return CustomModelMapper.parseObject(categoryRepository.save(found),
                CategoryDto.class);
    }

    public void delete(long id){
        var found = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoria não encontrada!"));
        categoryRepository.delete(found);
    }

}
