package com.pachimari.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by andrem on 27/03/2017.
 */
@Repository
public interface ProductsRepository extends MongoRepository<ProductEntity, String> {
    @Query("{$and: [ {$or : [ { $where: '?0 == null' } , { 'name' : ?0 }]}, {$or : [ { $where: '?1 == null' } , { 'brand' : ?1 }]}, {$or : [ { $where: '?2 == null' } , { typeId : ?2 }]} ] }")
    public List<ProductEntity> findByOptionalParameters(String name, String brand, Integer typeId);
    public List<ProductEntity> findAll();
    @Query("{$or :[{ $where: '?0 == null' }, { 'name' : ?0 }]}")
    List<ProductEntity> findProductsByName(String name);
}