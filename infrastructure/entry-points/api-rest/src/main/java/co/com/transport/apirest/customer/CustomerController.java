package co.com.transport.apirest.customer;

import co.com.transport.apirest.customer.RQ.CustomerRQ;
import co.com.transport.model.customer.Customer;
import co.com.transport.usecase.CustomerUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Ejemplo Controller", description = "Operaciones relacionadas con el ejemplo")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    private final ObjectMapper mapper;

    @PostMapping(path = "/add")
    public ResponseEntity<Customer> add(@RequestBody @Validated CustomerRQ customer) {

        return ResponseEntity.ok().body(customerUseCase.add(mapper.convertValue(customer,Customer.class)));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Customer> update(@RequestBody @Validated CustomerRQ customer) {

        return ResponseEntity.ok().body(customerUseCase.update(mapper.convertValue(customer,Customer.class)));
    }

    @GetMapping(path = "/all_customers")
    public ResponseEntity<List<Long>> getCustomers(){

        return ResponseEntity.ok().body(customerUseCase.getAll());
    }

}
