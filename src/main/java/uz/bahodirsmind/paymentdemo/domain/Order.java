package uz.bahodirsmind.paymentdemo.domain;

import lombok.Getter;
import lombok.Setter;
import uz.bahodirsmind.paymentdemo.payload.dto.OrderDTO;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "orders_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "orders_id_gen", sequenceName = "seq_orders_id", allocationSize = 1)
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_order_customer_id"))
    private Customer customer;

    public Order() {
    }

    public Order(Date date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }

    public OrderDTO mapToDto() {
        OrderDTO dto = new OrderDTO();
        dto.setId(id);
        dto.setDate(date);
        dto.setCustomerId(customer.getId());
        return dto;
    }
}
