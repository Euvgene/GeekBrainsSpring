package com.evgenii.lesson2;

import com.evgenii.lesson2.spring_config.SpringConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("Use command: \nadd + number of product to add \ndelete + number of product to delete" +
                "\nexit to close app.\n");
        Cart cart = context.getBean("cart", Cart.class);
        cartAction(cart);
        context.close();
    }

    public static void cartAction(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (b) {
            String command = scanner.next();
            if (command.startsWith("add")) {
                try {
                    cart.addProduct(scanner.nextInt());
                    System.out.println("Cart: " + cart.getProductList());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\nNumber of product incorrect! Try again.\n");
                }
            } else if (command.startsWith("delete")) {
                try {
                    cart.deleteProduct(scanner.nextInt());
                    System.out.println("Cart: " + cart.getProductList());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\nNumber of product incorrect! Try again.\n");
                }
            } else if (command.startsWith("exit")) {
                b = false;
            }
        }
        System.out.println("Finally in your cart:" + cart.getProductList());
    }
}
