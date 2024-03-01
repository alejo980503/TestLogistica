package co.com.transport.jpa.helper;

import co.com.transport.jpa.helper.util.ConstantsTest;
import co.com.transport.jpa.repository.customer.CustomerRepository;
import co.com.transport.jpa.repository.customer.CustomerRepositoryAdapter;
import co.com.transport.model.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdapterOperationsTest {

    @Mock
    private CustomerRepository repository;

    private ObjectMapper objectMapper;

    private CustomerRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapperImp();
        adapter = new CustomerRepositoryAdapter(repository, objectMapper);
    }

    @Test
    void testSave() {
        when(repository.save(Mockito.any())).thenReturn(ConstantsTest.getCustomerEntity());
        Customer result = adapter.save(ConstantsTest.getCustomer());
        assertEquals(result.getId(), ConstantsTest.getCustomerEntity().getId());
    }

    @Test
    void testSaveAllEntities() {
        when(repository.saveAll(ConstantsTest.getListCustomerEntity())).thenReturn(ConstantsTest.getListCustomerEntity());
        List<Customer> result = adapter.saveAllEntities(ConstantsTest.getListCustomer());
        assertTrue(result.size() > 0);
    }

    @Test
    void testFindById() {
        when(repository.findById(ConstantsTest.getCustomerEntity().getId()))
                .thenReturn(Optional.of(ConstantsTest.getCustomerEntity()));
        objectMapper = mock(ObjectMapper.class);
        when(objectMapper.map(Optional.of(ConstantsTest.getCustomerEntity()).get(), Customer.class))
                .thenReturn(ConstantsTest.getCustomer());
        Customer result = adapter.findById(ConstantsTest.getCustomerEntity().getId());
        assertEquals(ConstantsTest.getCustomerEntity().getId(), result.getId());
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(ConstantsTest.getListCustomerEntity());
        List<Customer> result = adapter.findAll();
        assertTrue(result.size()>0);
    }
}
