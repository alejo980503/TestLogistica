package co.com.transport.usecase;

import co.com.transport.model.warehousing.Warehousing;
import co.com.transport.model.warehousing.service.WarehousingService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WarehousingUseCase {

    private final WarehousingService warehousingService;

    public Warehousing add(Warehousing warehousing){

        return warehousingService.add(warehousing);
    }

    public List<Warehousing> list(){

        return warehousingService.list();
    }
}
