package co.com.transport.usecase;

import co.com.transport.model.transport.Transport;
import co.com.transport.model.transport.service.TransportService;
import co.com.transport.usecase.util.ConstantsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransportUseCaseTest {

    private TransportService transportService;
    private TransportUseCase transportUseCase;

    @BeforeAll
    public void setUp() {

        transportService = mock(TransportService.class);
        transportUseCase = new TransportUseCase(transportService);
    }

    @Test
    void addTest(){
        when(transportService.list()).thenReturn(ConstantsTest.getTransports());
        List<Transport> list = transportUseCase.list();
        Assertions.assertTrue(list.size() > 0);
    }
}
