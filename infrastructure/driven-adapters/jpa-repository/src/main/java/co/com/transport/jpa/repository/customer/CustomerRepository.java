package co.com.transport.jpa.repository.customer;

import co.com.transport.jpa.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>,
        QueryByExampleExecutor<CustomerEntity> {
}
