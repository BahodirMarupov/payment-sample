package uz.bahodirsmind.paymentdemo.domain;

import lombok.Getter;
import lombok.Setter;
import uz.bahodirsmind.paymentdemo.payload.enums.Countries;
import uz.bahodirsmind.paymentdemo.payload.dto.CustomerDTO;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(generator = "customer_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_id_gen", sequenceName = "seq_customer_id", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 14)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "country", length = 3)
    private Countries country;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    public Customer() {
    }

    public Customer(String name, Countries country, String address, String phone) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phone = phone;
    }

    public CustomerDTO mapToDto() {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setAddress(address);
        dto.setCountry(country.name);
        dto.setPhone(phone);
        return dto;
    }
}
