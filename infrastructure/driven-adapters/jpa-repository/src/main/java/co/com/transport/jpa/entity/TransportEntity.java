package co.com.transport.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "transport")
public class TransportEntity {

    @Id
    @Column(name = "transport_registration", nullable = false)
    private String transportRegistration;

    @Column(name = "type", nullable = false)
    private String type;


}
