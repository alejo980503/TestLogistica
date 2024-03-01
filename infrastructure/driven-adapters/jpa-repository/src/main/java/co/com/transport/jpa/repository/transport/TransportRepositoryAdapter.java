package co.com.transport.jpa.repository.transport;

import co.com.transport.jpa.entity.TransportEntity;
import co.com.transport.jpa.entity.WarehousingEntity;
import co.com.transport.jpa.helper.AdapterOperations;
import co.com.transport.model.exception.ValidationException;
import co.com.transport.model.transport.Transport;
import co.com.transport.model.transport.service.TransportService;
import co.com.transport.model.util.Constants;
import co.com.transport.model.warehousing.Warehousing;
import co.com.transport.model.warehousing.service.WarehousingService;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TransportRepositoryAdapter extends AdapterOperations<Transport, TransportEntity, String,
        TransportRepository> implements TransportService

{

    public TransportRepositoryAdapter(TransportRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Transport.class));
    }


    @Override
    public List<Transport> list() {
        List<Transport> list= new ArrayList<>();
        repository.findAll().forEach(transport -> list.add(mapper.map(transport,Transport.class)));

        return list;
    }

    @Override
    public Transport findById(String id){

        Optional<TransportEntity> optional=repository.findById(id);
        if (optional.isPresent()){
            return mapper.map(optional.get(), Transport.class);

        }
        else {
            throw new ValidationException(Constants.BAD_REQUEST, Constants.ERROR_CONSULTING_CUSTOMER,
                    Constants.CUSTOMER_NOT_EXIST);
        }
    }


}
