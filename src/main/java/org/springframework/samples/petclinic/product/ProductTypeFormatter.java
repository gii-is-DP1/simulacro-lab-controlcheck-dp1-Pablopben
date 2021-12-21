package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    private final ProductService prodServ;

    @Autowired
    public ProductTypeFormatter(ProductService prodServ){
        this.prodServ = prodServ;
    }

    @Override
    public String print(ProductType object, Locale locale) {
        // TODO Auto-generated method stub
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        // TODO Auto-generated method stub
        try {
           ProductType productTypes = this.prodServ.getProductType(text); 
           return productTypes;
        } catch (Exception e) {
            //TODO: handle exception
            throw new ParseException("product not found" + text, 0);
        } 
    }
    
}
