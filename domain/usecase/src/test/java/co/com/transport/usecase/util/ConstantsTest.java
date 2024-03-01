package co.com.transport.usecase.util;

import co.com.transport.model.customer.Customer;
import co.com.transport.model.product.Product;
import co.com.transport.model.product.ProductDetail;
import co.com.transport.model.shipment.Shipment;
import co.com.transport.model.transport.Transport;
import co.com.transport.model.warehousing.Warehousing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConstantsTest {

    public static Customer getCustomer(){

        return Customer.builder()
                .id(1L)
                .address("test")
                .email("test")
                .phone("test")
                .name("test")
                .build();
    }

    public static List<Transport> getTransports(){

        Transport transport= Transport.builder()
                .transportRegistration("test")
                .build();
        List<Transport> list= new ArrayList<>();
        list.add(transport);
        return list;
    }

    public static List<Shipment> getShipments(){

        Shipment shipment= Shipment.builder()
                .trackingNumber("test")
                .build();
        List<Shipment> list= new ArrayList<>();
        list.add(shipment);
        return list;
    }

    public static Transport getTransport(){

        return Transport.builder()
                .transportRegistration("test")
                .build();
    }

    public static ProductDetail productDetail(){

        return ProductDetail.builder()
                .product(getProduct())
                .shipment(getShipment())
                .build();

    }

    public static List<Long> getAll(){
        List<Long> list= new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        return list;
    }

    public static Product getProduct(){
        return Product.builder()
                .id(1L)
                .nameProduct("test")
                .productType("test")
                .referenceProduct("test")
                .build();
    }

    public static List<String> getAllProduct(){

        List<String> list= new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        return list;
    }

    public static Shipment getShipment(){

        Customer customer= Customer.builder()
                .id(1L)
                .build();
        Transport transport= Transport.builder()
                .transportRegistration("test")
                .build();

        List<Product> products= new ArrayList<>();
        products.add(getProduct());

        return Shipment.builder()
                .products(products)
                .transport(transport)
                .warehousing(Warehousing.builder()
                        .id(1L)
                        .build())
                .admissionDate("LocalDateTime.now()")
                .shippingType("test")
                .trackingNumber("test")
                .customer(customer)
                .build();
    }

    public static Warehousing getWarehousing(){

        return Warehousing.builder()
                .address("test")
                .id(1L)
                .warehousingType("test")
                .city("test")
                .build();
    }

}
