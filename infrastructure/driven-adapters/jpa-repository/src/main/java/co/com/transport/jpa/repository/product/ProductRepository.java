package co.com.transport.jpa.repository.product;

import co.com.transport.jpa.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ProductRepository extends CrudRepository<ProductEntity, Long>,
        QueryByExampleExecutor<ProductEntity> {
}
