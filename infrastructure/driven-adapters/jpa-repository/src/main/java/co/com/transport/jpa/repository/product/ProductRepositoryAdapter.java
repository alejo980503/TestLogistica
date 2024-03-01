package co.com.transport.jpa.repository.product;

import co.com.transport.jpa.entity.ProductEntity;
import co.com.transport.jpa.helper.AdapterOperations;
import co.com.transport.model.product.Product;
import co.com.transport.model.product.service.ProductService;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryAdapter extends AdapterOperations<Product, ProductEntity, Long,
        ProductRepository> implements ProductService

{

    public ProductRepositoryAdapter(ProductRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Product.class));
    }

    @Override
    public Product add(Product product) {
        return toEntity(repository.save(toData(product)));
    }

    @Override
    public List<String> getAll() {
        List<String> products = new ArrayList<>();
        repository.findAll().forEach(productEntity -> products.add(toEntity(productEntity).getNameProduct()));

        return products;
    }

}
