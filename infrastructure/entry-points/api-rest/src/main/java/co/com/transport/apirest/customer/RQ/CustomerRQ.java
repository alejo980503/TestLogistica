package co.com.transport.apirest.customer.RQ;

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
public class CustomerRQ {

    @Valid
    @NotNull(message = "es requerido")
    private Long id;

    private String name;

    private String phone;

    private String email;

    private String address;
}
