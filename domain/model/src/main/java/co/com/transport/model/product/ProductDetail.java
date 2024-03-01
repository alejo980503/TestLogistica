package co.com.transport.model.product;

import co.com.transport.model.shipment.Shipment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {


    private Long id;
    private Product product;
    private Shipment shipment;
}
