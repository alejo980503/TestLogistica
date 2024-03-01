package co.com.transport.apirest;

import co.com.transport.apirest.exception.ApplicationException;
import co.com.transport.apirest.login.TokenController;
import co.com.transport.apirest.util.ConstantsTest;
import co.com.transport.model.error.ErrorResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationExceptionTest {

    private ApplicationException applicationException;

    @BeforeAll
    public void setUp() {

        applicationException = new ApplicationException();
    }

    @Test
    void handleValidationExceptionTest(){
        ResponseEntity<ErrorResponse> errorResponseResponseEntity =
                applicationException.handleValidationException(ConstantsTest.getValidationException());
        Assertions.assertNotNull(errorResponseResponseEntity);
    }
}
