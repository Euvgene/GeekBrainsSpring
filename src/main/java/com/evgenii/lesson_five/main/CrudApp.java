package com.evgenii.lesson_five.main;

import com.evgenii.lesson_five.entity.Product;
import com.evgenii.lesson_five.service.ProductService;
import com.evgenii.lesson_five.service.ProductServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CrudApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        ProductService productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
        System.out.println(productService.getProduct());
        productService.saveOrUpdateCustomer(new Product("Lenovo",44300));
        System.out.println(productService.getProduct());
        productService.saveOrUpdateCustomer(new Product(6L,"Keks",123));
        System.out.println(productService.getProduct());
        System.out.println(productService.getProduct(4l));
        productService.deleteProduct(5L);
        System.out.println(productService.searchProduct("shoes"));
    }
}
