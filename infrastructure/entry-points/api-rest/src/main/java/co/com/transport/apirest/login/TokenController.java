package co.com.transport.apirest.login;

import co.com.transport.model.User;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;


@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class TokenController {

    private static final String SECRET_KEY = "claveSecreta";

    @GetMapping
    public ResponseEntity<User> login() {

        return ResponseEntity.ok().body(User.builder()
                        .token(Jwts.builder()
                                .setSubject("APP_ID")
                                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                                .compact())
                        .secretKey(SECRET_KEY)
                .build());

    }
}
