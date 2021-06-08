package uz.bahodirsmind.paymentdemo.payload.dto;

import lombok.Getter;
import lombok.Setter;
import uz.bahodirsmind.paymentdemo.domain.Invoice;
import uz.bahodirsmind.paymentdemo.exception.ResourceNotFound;
import uz.bahodirsmind.paymentdemo.repository.InvoiceRepository;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
public class InvoiceDTO {
    private Long id;
    @NotEmpty
    private Long orderId;
    private BigDecimal amount;
    private Date issued;
    private Date due;

    public Invoice mapToEntity(InvoiceRepository invoiceRepository) {
        Invoice entity = new Invoice();
        entity.setId(id);
        entity.setIssued(issued);
        entity.setDue(due);
        entity.setAmount(amount);
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(orderId);
        if (optionalInvoice.isPresent()) {
            entity.setOrder(optionalInvoice.get().getOrder());
        } else throw new ResourceNotFound("Order cannot be null!");
        return entity;
    }
}
