package co.com.transport.apirest.transport;

import co.com.transport.model.transport.Transport;
import co.com.transport.usecase.TransportUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transport")
@RequiredArgsConstructor
public class TransportController {

    private final TransportUseCase transportUseCase;

    @GetMapping(path ="/list")
    public ResponseEntity<List<Transport>> getList(){
        return ResponseEntity.ok().body(transportUseCase.list());
    }
}
