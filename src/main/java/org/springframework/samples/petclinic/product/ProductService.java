package org.springframework.samples.petclinic.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

private ProductRepository prodRepo;

    @Autowired
    public ProductService(ProductRepository prodRepo){
        this.prodRepo = prodRepo;
    }

    @Transactional
    public List<Product> getAllProducts(){
        return this.prodRepo.findAll();
    }

    @Transactional
    public List<Product> getProductsCheaperThan(double price) {
        List<Product> products = this.prodRepo.findAll();
        List<Product> res = new ArrayList<Product>();
        for (Product p:products){
            if(p.getPrice()<=price){
                res.add(p);
            }
        }
        
        return res;
    }

    @Transactional
    public ProductType getProductType(String typeName) {
        return this.prodRepo.findByName(typeName);
    }

    @Transactional
    public Product save(Product p){
        return this.prodRepo.save(p);       
    }

    
}
