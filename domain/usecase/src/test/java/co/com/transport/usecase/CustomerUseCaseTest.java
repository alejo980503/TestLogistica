package co.com.transport.usecase;

import co.com.transport.model.customer.Customer;
import co.com.transport.model.customer.servce.CustomerService;
import co.com.transport.usecase.util.ConstantsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerUseCaseTest {

    private CustomerUseCase customerUseCase;
    private CustomerService customerService;

    @BeforeAll
    public void setUp() {

        customerService = mock(CustomerService.class);
        customerUseCase = new CustomerUseCase(customerService);
    }

    @Test
    void addTest() {
        when(customerService.add(Mockito.any())).thenReturn(ConstantsTest.getCustomer());
        Customer customer = customerUseCase.add(ConstantsTest.getCustomer());
        Assertions.assertEquals(ConstantsTest.getCustomer().getId(), customer.getId());
    }

    @Test
    void updateTest() {
        when(customerService.findById(Mockito.any())).thenReturn(ConstantsTest.getCustomer());
        when(customerService.add(Mockito.any())).thenReturn(ConstantsTest.getCustomer());
        Customer customer = customerUseCase.update(ConstantsTest.getCustomer());
        Assertions.assertEquals(ConstantsTest.getCustomer().getId(), customer.getId());
    }

    @Test
    void getAllTest() {
        when(customerService.getAll()).thenReturn(ConstantsTest.getAll());
        List<Long> list = customerUseCase.getAll();
        Assertions.assertTrue(list.size() > 0);
    }


}
