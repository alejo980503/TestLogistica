package co.com.transport.usecase;

import co.com.transport.model.customer.Customer;
import co.com.transport.model.customer.servce.CustomerService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerUseCase {

    private final CustomerService customerService;

    public Customer add(Customer customer){

        return customerService.add(customer);
    }

    public Customer update(Customer customer) {
        Customer savedCustomer = customerService.findById(customer.getId());
        savedCustomer.setId(customer.getId());
        savedCustomer.setName(customer.getName());
        savedCustomer.setAddress(customer.getAddress());
        savedCustomer.setPhone(customer.getPhone());
        savedCustomer.setEmail(customer.getEmail());

        return customerService.add(savedCustomer);
    }

    public List<Long> getAll(){

        return customerService.getAll();
    }
}
