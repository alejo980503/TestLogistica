package co.com.transport.usecase;

import co.com.transport.model.transport.Transport;
import co.com.transport.model.transport.service.TransportService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransportUseCase {

    private final TransportService transportService;

    public List<Transport> list(){
        return transportService.list();
    }
}
