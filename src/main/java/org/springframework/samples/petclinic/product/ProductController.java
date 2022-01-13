package org.springframework.samples.petclinic.product;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

    @GetMapping("/create")
    public String initCreateForm(ModelMap modelMap){
        String view = VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
        modelMap.addAttribute("product", new Product());
        modelMap.addAttribute("productType", this.productService.findAllProductTypes());
        return view;
    }

    @PostMapping(value = "/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("product", product);
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		}
		else {
            this.productService.save(product);
        

        
            return "welcome";
		}
	}
}
