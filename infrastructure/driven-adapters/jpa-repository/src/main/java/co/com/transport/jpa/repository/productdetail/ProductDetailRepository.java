package co.com.transport.jpa.repository.productdetail;

import co.com.transport.jpa.entity.ProductDetailEntity;
import co.com.transport.jpa.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ProductDetailRepository extends CrudRepository<ProductDetailEntity, Long>,
        QueryByExampleExecutor<ProductDetailEntity> {
}
