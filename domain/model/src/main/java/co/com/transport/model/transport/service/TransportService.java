package co.com.transport.model.transport.service;

import co.com.transport.model.transport.Transport;

import java.util.List;

public interface TransportService {

    List<Transport> list();

    Transport findById(String id);
}
