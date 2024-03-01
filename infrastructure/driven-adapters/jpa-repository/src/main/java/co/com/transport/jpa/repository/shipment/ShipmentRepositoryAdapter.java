package co.com.transport.jpa.repository.shipment;

import co.com.transport.jpa.entity.ShipmentEntity;
import co.com.transport.jpa.helper.AdapterOperations;
import co.com.transport.model.exception.ValidationException;
import co.com.transport.model.shipment.Shipment;
import co.com.transport.model.shipment.service.ShipmentService;
import co.com.transport.model.util.Constants;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ShipmentRepositoryAdapter extends AdapterOperations<Shipment, ShipmentEntity, String, ShipmentRepository>
    implements ShipmentService

{

    public ShipmentRepositoryAdapter(ShipmentRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Shipment.class));
    }

    @Override
    public Shipment add(Shipment shipment) {

        return toEntity(repository.save(toData(shipment)));
    }

    public Shipment findById(String id){
        Optional<ShipmentEntity> optional=repository.findById(id);
        if (optional.isPresent()){
            return mapper.map(optional.get(), Shipment.class);
        }
        else {
            throw new ValidationException(Constants.BAD_REQUEST, Constants.ERROR_CONSULTING_CUSTOMER,
                    Constants.CUSTOMER_NOT_EXIST);
        }
    }

    @Override
    public List<Shipment> list() {
        List<Shipment> list = new ArrayList<>();
        repository.findAll().forEach(shipmentEntity -> list.add(toEntity(shipmentEntity)));

        return list;
    }
}
