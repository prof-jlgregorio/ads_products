package br.com.jlgregorio.Products.repository;

import br.com.jlgregorio.Products.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    public List<ProductModel> findByNameContainsIgnoreCase(String name);

}
