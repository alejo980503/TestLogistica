package co.com.transport.model.customer.servce;

import co.com.transport.model.customer.Customer;

import java.util.List;

public interface CustomerService {

    Customer add(Customer customer);

    Customer findById(Long id);

    List<Long> getAll();
}
