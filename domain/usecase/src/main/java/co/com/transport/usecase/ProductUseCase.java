package co.com.transport.usecase;

import co.com.transport.model.product.Product;
import co.com.transport.model.product.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductService productService;

    public Product add(Product customer){

        return productService.add(customer);
    }

    public List<String> getAll(){

        return productService.getAll();
    }
}
