package co.com.transport.apirest;

import co.com.transport.apirest.login.TokenController;
import co.com.transport.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TokenControllerTest {

    private TokenController tokenController;

    @BeforeAll
    public void setUp() {

        tokenController = new TokenController();
    }

    @Test
    void loginTest(){
        ResponseEntity<User> login =tokenController.login();
        Assertions.assertNotNull(login);
    }
}
