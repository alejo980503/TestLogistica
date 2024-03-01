package co.com.transport.usecase;

import co.com.transport.model.customer.servce.CustomerService;
import co.com.transport.model.product.service.ProductDetailService;
import co.com.transport.model.shipment.Shipment;
import co.com.transport.model.shipment.service.ShipmentService;
import co.com.transport.model.transport.service.TransportService;
import co.com.transport.model.warehousing.service.WarehousingService;
import co.com.transport.usecase.util.ConstantsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShipmentUseCaseTest {

    private ShipmentUseCase shipmentUseCase;
    private ShipmentService shipmentService;
    private CustomerService customerService;
    private WarehousingService warehousingService;
    private ProductDetailService productDetailService;
    private TransportService transportService;

    @BeforeAll
    public void setUp() {

        shipmentService = mock(ShipmentService.class);
        customerService = mock(CustomerService.class);
        warehousingService = mock(WarehousingService.class);
        productDetailService= mock(ProductDetailService.class);
        transportService = mock(TransportService.class);

        shipmentUseCase = new ShipmentUseCase(shipmentService, customerService, productDetailService, warehousingService,
                transportService);
    }

    @Test
    void addTest(){
        when(shipmentService.add(Mockito.any())).thenReturn(ConstantsTest.getShipment());
        when(customerService.findById(Mockito.any())).thenReturn(ConstantsTest.getCustomer());
        when(warehousingService.findById(ConstantsTest.getShipment().getWarehousing().getId())).thenReturn(ConstantsTest.getWarehousing());
        when(transportService.findById(ConstantsTest.getShipment().getTransport().getTransportRegistration())).thenReturn(ConstantsTest.getTransport());
        when(productDetailService.addProductDetail(Mockito.any())).thenReturn(ConstantsTest.productDetail());
        Shipment shipment = shipmentUseCase.add(ConstantsTest.getShipment());
        Assertions.assertEquals(ConstantsTest.getShipment().getShippingType(),shipment.getShippingType());

    }

    @Test
    void findByIdTest(){
        when(shipmentService.findById(Mockito.any())).thenReturn(ConstantsTest.getShipment());
        Shipment shipment = shipmentUseCase.findById(ConstantsTest.getShipment().getTrackingNumber());
        Assertions.assertEquals(ConstantsTest.getShipment().getTrackingNumber(), shipment.getTrackingNumber());
    }

    @Test
    void listTest(){
        when(shipmentService.list()).thenReturn(ConstantsTest.getShipments());
        List<Shipment> list = shipmentUseCase.list();
        Assertions.assertTrue(list.size() > 0);
    }

}
