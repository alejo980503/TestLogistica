package co.com.transport.apirest.product.RQ;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductRQ {

    private Long id;
    @Valid
    @NotNull(message = "es requerido")
    private String productType;
    @Valid
    @NotNull(message = "es requerido")
    private String nameProduct;
    @Valid
    @NotNull(message = "es requerido")
    private String referenceProduct;
}
