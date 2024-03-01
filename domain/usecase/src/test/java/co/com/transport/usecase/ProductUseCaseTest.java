package co.com.transport.usecase;

import co.com.transport.model.product.Product;
import co.com.transport.model.product.service.ProductService;
import co.com.transport.usecase.util.ConstantsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductUseCaseTest {

    private ProductUseCase productUseCase;
    private ProductService productService;

    @BeforeAll
    public void setUp() {

        productService = mock(ProductService.class);
        productUseCase = new ProductUseCase(productService);
    }

    @Test
    void addTest(){
        when(productService.add(Mockito.any())).thenReturn(ConstantsTest.getProduct());
        Product product = productUseCase.add(ConstantsTest.getProduct());
        Assertions.assertEquals(ConstantsTest.getProduct().getId(), product.getId());
    }

    @Test
    void getAllTest(){
        when(productService.getAll()).thenReturn(ConstantsTest.getAllProduct());
        List<String> list = productUseCase.getAll();
        Assertions.assertTrue(list.size()>0);
    }
}
