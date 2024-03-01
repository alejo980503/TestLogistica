package co.com.transport.model.shipment;

import co.com.transport.model.customer.Customer;
import co.com.transport.model.product.Product;
import co.com.transport.model.transport.Transport;
import co.com.transport.model.warehousing.Warehousing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    private String trackingNumber;
    private Double price;
    private Double normalPrice;
    private Double discount;
    private List<Product> products;
    private String shippingType;
    private String admissionDate;
    private String deliveryDate;
    private Transport transport;
    private Customer customer;
    private Warehousing warehousing;
}
