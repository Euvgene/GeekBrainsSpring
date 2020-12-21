package com.evgenii.lesson_six.main;


import com.evgenii.lesson_six.service.CustomerService;
import com.evgenii.lesson_six.service.CustomerServiceImpl;
import com.evgenii.lesson_six.service.ProductService;
import com.evgenii.lesson_six.service.ProductServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_config_lesson6.xml");
        ProductService productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
        CustomerService customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
        productService.getProductCustomers(3l);
        customerService.getCustomerProducts(1);
        customerService.getCustomerProducts(2);
        context.close();
    }
}