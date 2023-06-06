package com.melancholia.educationplatform.product;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public String allProducts(Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("count", productService.count());
        model.addAttribute("avg", productService.avg());
        model.addAttribute("sum", productService.sum());
        return "index";
    }

    @GetMapping("/product/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createProductForm(Model model){
        model.addAttribute("product", new Product());
        return "add";
    }

    @GetMapping("/product/{id}/edit")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editProduct(@PathVariable("id") String id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/product/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createProduct(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/";
    }

    @PostMapping("/product/{id}/edit")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editProduct(@PathVariable("id") String id, @ModelAttribute Product product){
        productService.update(id, product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteProductForm(@PathVariable("id") String id, Model model){
        model.addAttribute("product",  productService.findById(id));
        return "delete";
    }

    @PostMapping("/product/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteProduct(@PathVariable("id") String id){
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    @PreAuthorize("isAuthenticated()")
    public String getProduct(@PathVariable("id") String id, Model model){
        model.addAttribute("product",  productService.findById(id));
        return "product";
    }
}
