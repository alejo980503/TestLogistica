package co.com.transport.apirest.shipment.RQ;

import co.com.transport.apirest.customer.RQ.CustomerRQ;
import co.com.transport.apirest.warehousing.RQ.WarehousingRQ;
import co.com.transport.model.product.Product;
import co.com.transport.model.transport.Transport;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentRQ {
    @Valid
    @NotNull(message = "es requerido")
    private String trackingNumber;
    @Valid
    @NotNull(message = "es requerido")
    private Double price;
    @Valid
    @NotNull(message = "es requerido")
    private Double normalPrice;
    @Valid
    @NotNull(message = "es requerido")
    private Double discount;
    @Valid
    @NotNull(message = "es requerido")
    private List<Product> products;
    @Valid
    @NotNull(message = "es requerido")
    private String shippingType;
    @Valid
    @NotNull(message = "es requerido")
    private String admissionDate;
    @Valid
    @NotNull(message = "es requerido")
    private String deliveryDate;
    @Valid
    @NotNull(message = "es requerido")
    private Transport transport;
    @Valid
    @NotNull(message = "es requerido")
    private CustomerRQ customer;
    @Valid
    @NotNull(message = "es requerido")
    private WarehousingRQ warehousing;
}
