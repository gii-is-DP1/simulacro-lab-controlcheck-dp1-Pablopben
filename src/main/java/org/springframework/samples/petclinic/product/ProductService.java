package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getAllProducts(){
        List<Product> products = this.productRepository.findAll();
        return products;
    }
    @Transactional
    public List<Product> getProductsCheaperThan(double price) {
        return this.productRepository.findByPriceLessThan(price);
    }
    @Transactional
    public ProductType getProductType(String typeName) {

        return this.productRepository.findProductType(typeName);
    }
    @Transactional
    public Product save(Product p){
        return this.productRepository.save(p);       
    }
    @Transactional
    public List<ProductType> findAllProductTypes(){
        return this.productRepository.findAllProductTypes();
    }

    
}
