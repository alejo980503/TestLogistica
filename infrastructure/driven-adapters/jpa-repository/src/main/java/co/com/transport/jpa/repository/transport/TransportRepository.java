package co.com.transport.jpa.repository.transport;

import co.com.transport.jpa.entity.TransportEntity;
import co.com.transport.jpa.entity.WarehousingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TransportRepository extends CrudRepository<TransportEntity, String>,
        QueryByExampleExecutor<TransportEntity> {
}
