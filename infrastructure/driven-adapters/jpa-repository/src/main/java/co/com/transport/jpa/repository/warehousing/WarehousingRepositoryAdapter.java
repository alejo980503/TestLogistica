package co.com.transport.jpa.repository.warehousing;

import co.com.transport.jpa.entity.ShipmentEntity;
import co.com.transport.jpa.entity.WarehousingEntity;
import co.com.transport.jpa.helper.AdapterOperations;
import co.com.transport.model.exception.ValidationException;
import co.com.transport.model.shipment.Shipment;
import co.com.transport.model.util.Constants;
import co.com.transport.model.warehousing.Warehousing;
import co.com.transport.model.warehousing.service.WarehousingService;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WarehousingRepositoryAdapter extends AdapterOperations<Warehousing, WarehousingEntity, Long,
        WarehousingRepository> implements WarehousingService

{

    public WarehousingRepositoryAdapter(WarehousingRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Warehousing.class));
    }

    @Override
    public Warehousing add(Warehousing warehousing) {

        return toEntity(repository.save(toData(warehousing)));
    }

    @Override
    public List<Warehousing> list() {
        List<Warehousing> list= new ArrayList<>();
        repository.findAll().forEach(warehousingEntity -> list.add(mapper.map(warehousingEntity,Warehousing.class)));

        return list;
    }

    @Override
    public Warehousing findById(Long id){

        Optional<WarehousingEntity> optional=repository.findById(id);
        if (optional.isPresent()){
            Warehousing q= mapper.map(optional.get(), Warehousing.class);
            return q;
        }
        else {
            throw new ValidationException(Constants.BAD_REQUEST, Constants.ERROR_CONSULTING_CUSTOMER,
                    Constants.CUSTOMER_NOT_EXIST);
        }
    }

}
