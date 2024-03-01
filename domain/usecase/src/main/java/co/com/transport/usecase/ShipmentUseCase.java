package co.com.transport.usecase;

import co.com.transport.model.customer.Customer;
import co.com.transport.model.customer.servce.CustomerService;
import co.com.transport.model.product.ProductDetail;
import co.com.transport.model.product.service.ProductDetailService;
import co.com.transport.model.shipment.Shipment;
import co.com.transport.model.shipment.service.ShipmentService;
import co.com.transport.model.transport.Transport;
import co.com.transport.model.transport.service.TransportService;
import co.com.transport.model.warehousing.Warehousing;
import co.com.transport.model.warehousing.service.WarehousingService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShipmentUseCase {

    private final ShipmentService shipmentService;
    private final CustomerService customerService;

    private final ProductDetailService productDetailService;

    private final WarehousingService warehousingService;

    private final TransportService transportService;


    public Shipment add(Shipment shipment) {
        Customer customer = customerService.findById(shipment.getCustomer().getId());
        shipment.setCustomer(customer);
        Warehousing warehousing=warehousingService.findById(shipment.getWarehousing().getId());
        shipment.setWarehousing(warehousing);
        Transport transport=transportService.findById(shipment.getTransport().getTransportRegistration());
        shipment.setTransport(transport);
        Shipment shipmentEntity = shipmentService.add(shipment);

        if (!shipment.getProducts().isEmpty()) {
            for (int i = 0; i < shipment.getProducts().size(); i++) {
                ProductDetail productDetail = ProductDetail.builder()
                        .shipment(shipmentEntity)
                        .product(shipment.getProducts().get(i))
                        .build();
                productDetailService.addProductDetail(productDetail);
            }
        }

        return shipmentEntity;

    }

    public Shipment findById(String id) {

        return shipmentService.findById(id);
    }

    public List<Shipment> list(){

        return shipmentService.list();
    }
}
