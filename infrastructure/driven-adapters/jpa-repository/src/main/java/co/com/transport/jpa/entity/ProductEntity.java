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
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "id_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "productType", nullable = false)
    private String productType;

    @Column(name = "name_product", nullable = false)
    private String nameProduct;

    @Column(name = "reference_product", nullable = false)
    private String referenceProduct;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductDetailEntity> productDetail;
}
