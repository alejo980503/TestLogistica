package co.com.transport.config;

import co.com.transport.model.customer.servce.CustomerService;
import co.com.transport.model.product.service.ProductDetailService;
import co.com.transport.model.product.service.ProductService;
import co.com.transport.model.shipment.service.ShipmentService;
import co.com.transport.model.transport.service.TransportService;
import co.com.transport.model.warehousing.service.WarehousingService;
import co.com.transport.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

    @Bean
    public CustomerUseCase customerUseCase(CustomerService customerService) {

        return new CustomerUseCase(customerService);
    }

    @Bean
    public ProductUseCase productUseCase(ProductService productService) {

        return new ProductUseCase(productService);
    }

    @Bean
    public WarehousingUseCase warehousingUseCase(WarehousingService warehousingService) {

        return new WarehousingUseCase(warehousingService);
    }

    @Bean
    public ShipmentUseCase shipmentUseCase(ShipmentService shipmentService, CustomerService customerService,
                                           ProductDetailService productDetailService, WarehousingService warehousingService,
                                           TransportService transportService){
        return new ShipmentUseCase(shipmentService, customerService, productDetailService, warehousingService,
                transportService);
    }

    @Bean
    public TransportUseCase transportUseCase(TransportService transportService) {

        return new TransportUseCase(transportService);
    }
}
