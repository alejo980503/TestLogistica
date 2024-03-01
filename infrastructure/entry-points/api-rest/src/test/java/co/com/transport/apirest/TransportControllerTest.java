package co.com.transport.apirest;

import co.com.transport.apirest.transport.TransportController;
import co.com.transport.apirest.util.ConstantsTest;
import co.com.transport.model.transport.Transport;
import co.com.transport.usecase.TransportUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransportControllerTest {

    private TransportUseCase transportUseCase;

    private TransportController transportController;

    @BeforeAll
    public void setUp() {

        transportUseCase = mock(TransportUseCase.class);
        transportController = new TransportController(transportUseCase);
    }

    @Test
    void listTest(){

        when(transportUseCase.list()).thenReturn(ConstantsTest.getList());
        ResponseEntity<List<Transport>> transportControllerList=transportController
                .getList();
        Assertions.assertTrue(Objects.requireNonNull(transportControllerList.getBody()).size() > 0);
    }
}
