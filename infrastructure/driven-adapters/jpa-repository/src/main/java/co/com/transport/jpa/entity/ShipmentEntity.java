package co.com.transport.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "shipment")
public class ShipmentEntity {

    @Id
    @Column(name = "tracking_number", nullable = false)
    private String trackingNumber;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "normal_price", nullable = false)
    private Double normalPrice;

    @Column(name = "discount", nullable = false)
    private Double discount;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductDetailEntity> productDetail;

    @Column(name = "shipping_type", nullable = false)
    private String shippingType;

    @Column(name = "admission_date", nullable = false)
    private String admissionDate;

    @Column(name = "delivery_date", nullable = false)
    private String deliveryDate;

    @JoinColumn(name = "transport")
    @ManyToOne(cascade = CascadeType.MERGE)
    private TransportEntity transport;

    @JoinColumn(name = "customer")
    @ManyToOne(cascade = CascadeType.MERGE)
    private CustomerEntity customer;

    @JoinColumn(name = "warehousing")
    @ManyToOne(cascade = CascadeType.MERGE)
    private WarehousingEntity warehousing;

}
