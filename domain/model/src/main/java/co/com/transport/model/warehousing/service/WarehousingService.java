package co.com.transport.model.warehousing.service;

import co.com.transport.model.warehousing.Warehousing;

import java.util.List;

public interface WarehousingService {

  Warehousing add(Warehousing warehousing);

  List<Warehousing> list();

  Warehousing findById(Long id);

}
