package br.com.jlgregorio.Products.repository;

import br.com.jlgregorio.Products.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    public List<CategoryModel> findByNameContainsIgnoreCase(String name);


}
