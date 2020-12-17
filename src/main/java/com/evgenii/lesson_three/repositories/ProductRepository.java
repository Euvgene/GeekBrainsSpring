package com.evgenii.lesson_three.repositories;

import com.evgenii.lesson_three.model.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList.add(new Product(123546L, "Boots", new BigDecimal("1258.15").setScale(2, BigDecimal.ROUND_HALF_UP)));
        productList.add(new Product(124678L, "T-shirt", new BigDecimal("1859.15").setScale(2, BigDecimal.ROUND_HALF_UP)));
        productList.add(new Product(789563L, "Hat", new BigDecimal("1185.48").setScale(2, BigDecimal.ROUND_HALF_UP)));
        productList.add(new Product(148792L, "Shorts", new BigDecimal("1135.48").setScale(2, BigDecimal.ROUND_HALF_UP)));
        productList.add(new Product(789652L, "Shoes", new BigDecimal("1885.48").setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Product getById(int i) {
        return this.productList.get(i - 1);
    }
    public void save(Product product) {
        productList.add(product);
    }

    public void deleteById(Long id) {
        productList.removeIf(b -> b.getId().equals(id));
    }
}
