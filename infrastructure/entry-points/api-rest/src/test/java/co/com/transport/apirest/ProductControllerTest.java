package co.com.transport.apirest;

import co.com.transport.apirest.product.ProductController;
import co.com.transport.apirest.util.ConstantsTest;
import co.com.transport.model.product.Product;
import co.com.transport.usecase.ProductUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductControllerTest {

    private ProductUseCase productUseCase;
    private ProductController productController;
    private ObjectMapper objectMapper;

    @BeforeAll
    public void setUp() {

        productUseCase = mock(ProductUseCase.class);
        objectMapper= mock(ObjectMapper.class);
        productController = new ProductController(productUseCase,objectMapper);
    }

    @Test
    void allTest(){
        when(productUseCase.add(Mockito.any())).thenReturn(ConstantsTest.getProduct());
        when(objectMapper.convertValue(ConstantsTest.getProductRQ(), Product.class)).thenReturn(ConstantsTest.getProduct());
        ResponseEntity<Product> productResponseEntity = productController.add(ConstantsTest.getProductRQ());
        Assertions.assertEquals(ConstantsTest.getCustomer().getId(),
                Objects.requireNonNull(productResponseEntity.getBody()).getId());
    }

    @Test
    void allProductsTest(){
        when(productUseCase.getAll()).thenReturn(ConstantsTest.getAllProduct());
        ResponseEntity<List<String>> listResponseEntity = productController.getCustomers();
        Assertions.assertTrue(Objects.requireNonNull(listResponseEntity.getBody()).size() > 0);
    }

}
