package com.pachimari.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by andrem on 23/03/2017.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepositoryJdbc productRepositoryJdbc;
    @Autowired
    List<ProductEntityDto> productEntityDTOS;

    @GetMapping
    public List<ProductEntityDto> getAllProducts() {
        productEntityDTOS.clear();
        List<ProductEntity> productEntities = productRepositoryJdbc.findAll();
        for(ProductEntity product: productEntities){
            productEntityDTOS.add(ProductAdapter.fromProductToDto(product));
        }
        return productEntityDTOS;
    }
}
