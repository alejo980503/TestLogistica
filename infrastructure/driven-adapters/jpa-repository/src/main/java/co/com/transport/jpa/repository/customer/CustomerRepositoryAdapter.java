package co.com.transport.jpa.repository.customer;

import co.com.transport.jpa.entity.CustomerEntity;
import co.com.transport.jpa.helper.AdapterOperations;
import co.com.transport.model.customer.Customer;
import co.com.transport.model.customer.servce.CustomerService;
import co.com.transport.model.exception.ValidationException;
import co.com.transport.model.util.Constants;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryAdapter extends AdapterOperations<Customer, CustomerEntity, Long, CustomerRepository>
    implements CustomerService
{

    public CustomerRepositoryAdapter(CustomerRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Customer.class));
    }

    @Override
    public Customer add(Customer customer) {

        return toEntity(repository.save(toData(customer)));
    }

    @Override
    public Customer findById(Long id){
        Optional<CustomerEntity> optional=repository.findById(id);
        if (optional.isPresent()){
                return mapper.map(optional.get(), Customer.class);
        }
        else {
            throw new ValidationException(Constants.BAD_REQUEST, Constants.ERROR_CONSULTING_CUSTOMER,
                    Constants.CUSTOMER_NOT_EXIST);
        }
    }

    @Override
    public List<Long> getAll() {
        List<Long> idCustomers = new ArrayList<>();
        repository.findAll().forEach(customerEntity -> idCustomers.add(toEntity(customerEntity).getId()));

        return idCustomers;
    }
}
