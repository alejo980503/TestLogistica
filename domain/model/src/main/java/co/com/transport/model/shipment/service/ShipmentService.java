package co.com.transport.model.shipment.service;

import co.com.transport.model.shipment.Shipment;

import java.util.List;

public interface ShipmentService {

    Shipment add(Shipment shipment);

    Shipment findById(String id);

    List<Shipment> list();
}
