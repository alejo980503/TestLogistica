package co.com.transport.jpa.repository.warehousing;

import co.com.transport.jpa.entity.WarehousingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface WarehousingRepository extends CrudRepository<WarehousingEntity, Long>,
        QueryByExampleExecutor<WarehousingEntity> {
}
