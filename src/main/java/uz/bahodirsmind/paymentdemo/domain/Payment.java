package uz.bahodirsmind.paymentdemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(generator = "payment_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "payment_id_gen", sequenceName = "seq_payment_id", allocationSize = 1)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Date time;

    @Column(name = "amount", precision = 8, scale = 2)
    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_invoice_payment_id"))
    private Invoice invoice;

    public Payment() {
    }

    public Payment(Date time, BigDecimal amount, Invoice invoice) {
        this.time = time;
        this.amount = amount;
        this.invoice = invoice;
    }
}
