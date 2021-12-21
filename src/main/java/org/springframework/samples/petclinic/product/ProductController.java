package org.springframework.samples.petclinic.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {

    private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

    private final ProductService prodServ;

    @Autowired
    public ProductController(ProductService prodServ){
        this.prodServ = prodServ;
    }

    @GetMapping(value = "/products/create")
	public String initCreationForm(ModelMap model) {
		Product prod = new Product();
		model.put("product", prod);
		return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/pets/new")
	public String processCreationForm(ProductType productType, @Valid Product product, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("product", product);
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		}
		else {
            product.setProductType(productType);
            this.prodServ.save(product);
            return "/welcome";
		}
	}
    
}
