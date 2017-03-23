package com.pachimari.product;

/**
 * Created by andrem on 23/03/2017.
 */
public class ProductAdapter {

    public static ProductEntityDto fromProductToDto(ProductEntity product){
        return ProductEntityDto.builder()
                .name(product.getName())
                .brand(product.getBrand())
                .typeId(product.getTypeId())
                .price(product.getPrice())
                .imageURL(product.getImageURL())
                .build();
    }

    public static ProductEntity fromDtoToProduct(ProductEntityDto productDto){
        return ProductEntity.builder()
                .name(productDto.getName())
                .brand(productDto.getBrand())
                .typeId(productDto.getTypeId())
                .price(productDto.getPrice())
                .imageURL(productDto.getImageURL())
                .build();
    }

}
