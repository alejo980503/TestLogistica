package co.com.transport.model.product.service;

import co.com.transport.model.product.Product;

import java.util.List;

public interface ProductService {

    Product add(Product product);

    List<String> getAll();


}
