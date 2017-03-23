package com.pachimari.product;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by andrem on 23/03/2017.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntityDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String brand;
    @NotNull
    private int typeId;
    @NotNull
    private double price;
    @NotNull
    private String imageURL;
}
