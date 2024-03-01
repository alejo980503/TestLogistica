package co.com.transport.apirest.product;

import co.com.transport.apirest.product.RQ.ProductRQ;
import co.com.transport.model.product.Product;
import co.com.transport.usecase.ProductUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase productUseCase;

    private final ObjectMapper objectMapper;

    @PostMapping(path = "/add")
    public ResponseEntity<Product> add(@RequestBody @Validated ProductRQ product) {

        return ResponseEntity.ok().body(productUseCase.add(objectMapper.convertValue(product, Product.class)));
    }

    @GetMapping(path = "/all_products")
    public ResponseEntity<List<String>> getCustomers(){

        return ResponseEntity.ok().body(productUseCase.getAll());
    }
}
