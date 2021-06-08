package uz.bahodirsmind.paymentdemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "details")
public class Detail {

    @Id
    @GeneratedValue(generator = "details_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "details_id_gen", sequenceName = "seq_details_id", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ord_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_detail_order_id"))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "pr_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_detail_product_id"))
    private Product product;

    @Column(name = "quantity")
    private Short quantity;

    public Detail() {
    }

    public Detail(Order order, Product product, Short quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }
}
