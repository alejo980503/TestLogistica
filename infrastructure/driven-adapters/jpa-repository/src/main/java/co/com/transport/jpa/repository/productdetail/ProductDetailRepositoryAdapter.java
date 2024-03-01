package co.com.transport.jpa.repository.productdetail;

import co.com.transport.jpa.entity.ProductDetailEntity;
import co.com.transport.jpa.entity.ProductEntity;
import co.com.transport.jpa.helper.AdapterOperations;
import co.com.transport.model.product.Product;
import co.com.transport.model.product.ProductDetail;
import co.com.transport.model.product.service.ProductDetailService;
import co.com.transport.model.product.service.ProductService;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDetailRepositoryAdapter extends AdapterOperations<ProductDetail, ProductDetailEntity, Long,
        ProductDetailRepository> implements ProductDetailService

{

    public ProductDetailRepositoryAdapter(ProductDetailRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, ProductDetail.class));
    }


    @Override
    public ProductDetail addProductDetail(ProductDetail productDetail) {
        return toEntity(repository.save(toData(productDetail)));
    }
}
