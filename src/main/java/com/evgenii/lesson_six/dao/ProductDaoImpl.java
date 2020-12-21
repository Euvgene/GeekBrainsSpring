package com.evgenii.lesson_six.dao;

import com.evgenii.lesson_six.entity.Customer;
import com.evgenii.lesson_six.entity.Product;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {
    private final SessionFactory sessionFactory;

    @Override
    public void getProductCustomers(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product product =  currentSession.get(Product.class, id);
        System.out.println( product);
        for (Customer b : product.getCustomerList()) {
            System.out.println(b.getName());
        }
    }
}
