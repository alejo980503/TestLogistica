package co.com.transport.apirest.shipment;

import co.com.transport.apirest.shipment.RQ.ShipmentRQ;
import co.com.transport.model.shipment.Shipment;
import co.com.transport.usecase.ShipmentUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "message", description = "the message API")
@RestController
@RequestMapping(value = "/shipment", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "EjemploController", description = "Controlador de ejemplo para Swagger")
public class ShipmentController {


    private final ShipmentUseCase shipmentUseCase;
    private final ObjectMapper objectMapper;

    @PostMapping(path = "/add")
    public ResponseEntity<Shipment> add(@RequestBody @Validated ShipmentRQ shipment) {
        return ResponseEntity.ok().body(shipmentUseCase.add(objectMapper.convertValue(shipment, Shipment.class)));
    }

    @GetMapping(path = "/findById")
    public ResponseEntity<Shipment> finById(@RequestParam("id") String id) {

        return ResponseEntity.ok().body(shipmentUseCase.findById(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Shipment>> list(){

        return ResponseEntity.ok().body(shipmentUseCase.list());
    }

}
