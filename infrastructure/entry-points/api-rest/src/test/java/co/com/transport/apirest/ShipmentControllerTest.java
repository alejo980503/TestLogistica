package co.com.transport.apirest;

import co.com.transport.apirest.shipment.ShipmentController;
import co.com.transport.apirest.util.ConstantsTest;
import co.com.transport.model.shipment.Shipment;
import co.com.transport.usecase.ShipmentUseCase;
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
public class ShipmentControllerTest {

    private ShipmentUseCase shipmentUseCase;
    private ShipmentController shipmentController;

    private ObjectMapper objectMapper;

    @BeforeAll
    public void setUp() {

        shipmentUseCase = mock(ShipmentUseCase.class);
        objectMapper = mock(ObjectMapper.class);
        shipmentController = new ShipmentController(shipmentUseCase, objectMapper);
    }

    @Test
    void addTest(){
        when(shipmentUseCase.add(Mockito.any())).thenReturn(ConstantsTest.getShipment());
        when(objectMapper.convertValue(ConstantsTest.getShipmentRQ(), Shipment.class)).thenReturn(ConstantsTest.getShipment());
        ResponseEntity<Shipment> shipmentResponseEntity= shipmentController.add(ConstantsTest.getShipmentRQ());
        Assertions.assertEquals(ConstantsTest.getShipment().getTrackingNumber(),
                Objects.requireNonNull(shipmentResponseEntity.getBody()).getTrackingNumber());
    }

    @Test
    void findById(){
        when(shipmentUseCase.findById(Mockito.any())).thenReturn(ConstantsTest.getShipment());
        ResponseEntity<Shipment> shipmentResponseEntity=shipmentController.
                finById(ConstantsTest.getShipment().getTrackingNumber());
        Assertions.assertEquals(ConstantsTest.getShipment().getTrackingNumber(),
                Objects.requireNonNull(shipmentResponseEntity.getBody()).getTrackingNumber());
    }

    @Test
    void listTest(){

        when(shipmentUseCase.list()).thenReturn(ConstantsTest.getListShipmentV2());
        ResponseEntity<List<Shipment>> responseEntity = shipmentController.list();
        Assertions.assertTrue(Objects.requireNonNull(responseEntity.getBody()).size() > 0);
    }

}
