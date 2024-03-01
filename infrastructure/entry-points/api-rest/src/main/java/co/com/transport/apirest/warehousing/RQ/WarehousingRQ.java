package co.com.transport.apirest.warehousing.RQ;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class WarehousingRQ {

    private Long id;
    private String country;
    private String city;
    private String address;
    private String warehousingType;

}
