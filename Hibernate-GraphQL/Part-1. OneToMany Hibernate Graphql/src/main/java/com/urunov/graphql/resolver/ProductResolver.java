package com.urunov.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.urunov.graphql.model.Customer;
import com.urunov.graphql.model.Product;
import com.urunov.graphql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: apple
 * @created on 07/09/2020
 * @Project is OnetoMany
 */
public class ProductResolver implements GraphQLResolver<Product> {

    @Autowired
    private CustomerRepository customerRepository;

    public ProductResolver(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Product product){
        return customerRepository.findById(product.getCustomer().getCid()).orElseThrow(null);
    }
}
