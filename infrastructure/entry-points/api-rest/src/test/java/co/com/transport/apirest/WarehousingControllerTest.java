package co.com.transport.apirest;

import co.com.transport.apirest.util.ConstantsTest;
import co.com.transport.apirest.warehousing.WarehousingController;
import co.com.transport.model.customer.Customer;
import co.com.transport.model.warehousing.Warehousing;
import co.com.transport.usecase.WarehousingUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WarehousingControllerTest {

    private WarehousingUseCase warehousingUseCase;
    private WarehousingController warehousingController;
    private ObjectMapper objectMapper;

    @BeforeAll
    public void setUp() {

        warehousingUseCase = mock(WarehousingUseCase.class);
        objectMapper= mock(ObjectMapper.class);
        warehousingController = new WarehousingController(warehousingUseCase,objectMapper);
    }

    @Test
    void addTest() {
        when(warehousingUseCase.add(Mockito.any())).thenReturn(ConstantsTest.getWarehousing());
        when(objectMapper.convertValue(ConstantsTest.getWarehousingRQ(), Warehousing.class)).thenReturn(ConstantsTest.getWarehousing());
        ResponseEntity<Warehousing> warehousingResponseEntity = warehousingController.add(ConstantsTest.getWarehousingRQ());
        Assertions.assertEquals(ConstantsTest.getWarehousing().getId(),
                Objects.requireNonNull(warehousingResponseEntity.getBody()).getId());

    }
}
