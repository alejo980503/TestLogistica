package co.com.transport.apirest;

import co.com.transport.apirest.customer.CustomerController;
import co.com.transport.apirest.util.ConstantsTest;
import co.com.transport.model.customer.Customer;
import co.com.transport.usecase.CustomerUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerControllerTest {

    private CustomerUseCase customerUseCase;

    private CustomerController customerController;

    private ObjectMapper objectMapper;

    @BeforeAll
    public void setUp() {

        customerUseCase = mock(CustomerUseCase.class);
        objectMapper = mock(ObjectMapper.class);
        customerController = new CustomerController(customerUseCase,objectMapper);
    }

    @Test
    void addTest(){
        when(customerUseCase.add(Mockito.any())).thenReturn(ConstantsTest.getCustomer());
        when(objectMapper.convertValue(ConstantsTest.getCustomerRQ(),Customer.class)).thenReturn(ConstantsTest.getCustomer());
        ResponseEntity<Customer> customerResponseEntity= customerController.add(ConstantsTest.getCustomerRQ());
        Assertions.assertEquals(ConstantsTest.getCustomer().getId(),
               Objects.requireNonNull(customerResponseEntity.getBody()).getId());
    }

    @Test
    void updateTest(){
        when(customerUseCase.update(Mockito.any())).thenReturn(ConstantsTest.getCustomer());
        when(objectMapper.convertValue(ConstantsTest.getCustomerRQ(),Customer.class)).thenReturn(ConstantsTest.getCustomer());
        ResponseEntity<Customer> customerResponseEntity= customerController.update(ConstantsTest.getCustomerRQ());
        Assertions.assertEquals(ConstantsTest.getCustomer().getId(),
                Objects.requireNonNull(customerResponseEntity.getBody()).getId());
    }

    @Test
    void allCustomerTest(){
        when(customerUseCase.getAll()).thenReturn(ConstantsTest.getAll());
        ResponseEntity<List<Long>> customerResponseEntity=customerController.getCustomers();
        Assertions.assertTrue(Objects.requireNonNull(customerResponseEntity.getBody()).size() > 0);
    }
}
