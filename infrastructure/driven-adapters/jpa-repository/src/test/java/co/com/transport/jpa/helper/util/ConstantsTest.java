package co.com.transport.jpa.helper.util;

import co.com.transport.jpa.entity.CustomerEntity;
import co.com.transport.model.customer.Customer;
import co.com.transport.model.exception.ValidationException;
import co.com.transport.model.product.Product;
import co.com.transport.model.shipment.Shipment;
import co.com.transport.model.warehousing.Warehousing;

import java.util.ArrayList;
import java.util.List;

public class ConstantsTest {

    public static CustomerEntity getCustomerEntity(){

        return CustomerEntity.builder()
                .id(1L)
                .address("test")
                .email("test")
                .phone("test")
                .name("test")
                .build();
    }

    public static List<Customer> getListCustomer(){

        Customer customer= Customer.builder()
                .id(1L)
                .address("test")
                .email("test")
                .phone("test")
                .name("test")
                .build();
        List<Customer> customers= new ArrayList<>();
        customers.add(customer);
        return  customers;
    }

    public static List<CustomerEntity> getListCustomerEntity(){

        CustomerEntity customer= CustomerEntity.builder()
                .id(1L)
                .address("test")
                .email("test")
                .phone("test")
                .name("test")
                .build();
        List<CustomerEntity> customers= new ArrayList<>();
        customers.add(customer);
        return customers;
    }

    public static Customer getCustomer(){

        return Customer.builder()
                .id(1L)
                .address("test")
                .email("test")
                .phone("test")
                .name("test")
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
        return Shipment.builder()
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

    public static ValidationException getValidationException(){

        return new ValidationException("test","test","test");
    }


}
