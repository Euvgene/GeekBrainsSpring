package com.evgenii.lesson2;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class ProductRepository {
    private List<Product> productList;

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    @PostConstruct
    public void init() {
        int i = 1;
        productList.add(new Product(i++, "Boots", 1230));
        productList.add(new Product(i++, "T-shirt", 1100));
        productList.add(new Product(i++, "Hat", 590));
        productList.add(new Product(i++, "Shorts", 5200));
        productList.add(new Product(i++, "Shoes", 3258));
    }

    public Product getById(int i) {
        return this.productList.get(i - 1);
    }
}
