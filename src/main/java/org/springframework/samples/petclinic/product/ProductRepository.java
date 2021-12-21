package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, String>{
    List<Product> findAll();
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    //Product findByName(String name);
    ProductType findByName(String name);
    List<Product> findByPriceLessThan(Double price);
    Product save(Product p);
}
