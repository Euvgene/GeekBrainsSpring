package com.evgenii.lesson_three.controller;

import com.evgenii.lesson_three.model.Product;
import com.evgenii.lesson_three.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
private ProductService productService;
    @GetMapping("/change_products")
    public String changeProductList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "change_products";
    }
    @GetMapping("/all")
    public String getAllBoxes(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "all_products";
    }

    @GetMapping("/add_form")
    public String addPage() {
        return "add_product";
    }

    @PostMapping("/add")
    public String addNewBox(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/change_products";
    }

    @GetMapping("/remove/{id}")
    public String deleteBoxById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/change_products";
    }
}
