package co.com.transport.apirest.warehousing;

import co.com.transport.apirest.warehousing.RQ.WarehousingRQ;
import co.com.transport.model.warehousing.Warehousing;
import co.com.transport.usecase.WarehousingUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/warehousing", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class WarehousingController {

    private final WarehousingUseCase warehousingUseCase;
    private final ObjectMapper objectMapper;

    @PostMapping(path = "/add")
    public ResponseEntity<Warehousing> add(@RequestBody @Validated WarehousingRQ warehousing) {

        return ResponseEntity.ok().body(warehousingUseCase.add(objectMapper.convertValue(warehousing,Warehousing.class)));
    }

    @GetMapping(path ="/list")
    public ResponseEntity<List<Warehousing>> getList(){
            return ResponseEntity.ok().body(warehousingUseCase.list());
    }
}
