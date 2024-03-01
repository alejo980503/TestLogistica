package co.com.transport.jpa.repository.shipment;

import co.com.transport.jpa.entity.ShipmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ShipmentRepository extends CrudRepository<ShipmentEntity, String>,
        QueryByExampleExecutor<ShipmentEntity> {
}
