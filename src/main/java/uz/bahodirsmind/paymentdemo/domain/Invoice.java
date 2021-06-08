package uz.bahodirsmind.paymentdemo.domain;

import lombok.Getter;
import lombok.Setter;
import uz.bahodirsmind.paymentdemo.payload.dto.InvoiceDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(generator = "invoices_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "invoices_id_gen", sequenceName = "seq_invoices_id", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_order_invoice_id"))
    private Order order;

    @Column(name = "amount", precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "issued")
    @Temporal(TemporalType.DATE)
    private Date issued;

    @Column(name = "due")
    @Temporal(TemporalType.DATE)
    private Date due;

    public Invoice() {
    }

    public Invoice(Order order, BigDecimal amount, Date issued, Date due) {
        this.order = order;
        this.amount = amount;
        this.issued = issued;
        this.due = due;
    }

    public InvoiceDTO mapToDto() {
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(id);
        dto.setIssued(issued);
        dto.setDue(due);
        dto.setAmount(amount);
        if (order != null) {
            dto.setOrderId(order.getId());
        }
        return dto;
    }
}
