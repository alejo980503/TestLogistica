package co.com.transport.usecase;

import co.com.transport.model.warehousing.Warehousing;
import co.com.transport.model.warehousing.service.WarehousingService;
import co.com.transport.usecase.util.ConstantsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WarehousingUseCaseTest {

    private WarehousingUseCase warehousingUseCase;
    private WarehousingService warehousingService;

    @BeforeAll
    public void setUp() {

        warehousingService = mock(WarehousingService.class);
        warehousingUseCase = new WarehousingUseCase(warehousingService);
    }

    @Test
    void addTest(){
        when(warehousingService.add(any())).thenReturn(ConstantsTest.getWarehousing());
        Warehousing warehousing = warehousingUseCase.add(ConstantsTest.getWarehousing());
        Assertions.assertEquals(ConstantsTest.getWarehousing().getId(), warehousing.getId());
    }
}
