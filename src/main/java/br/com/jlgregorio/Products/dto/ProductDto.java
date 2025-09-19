package br.com.jlgregorio.Products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private long id;

    private String name;

    private CategoryDto category;

}
