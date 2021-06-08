package uz.bahodirsmind.paymentdemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uz.bahodirsmind.paymentdemo.domain.Invoice;
import uz.bahodirsmind.paymentdemo.payload.response.WrongDateResponse;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    @Query("select i from Invoice i where i.issued > i.due")
    List<Invoice> findAllExpiredInvoices();

    @Query("select new uz.bahodirsmind.paymentdemo.payload.response.WrongDateResponse(" +
            "i.id, i.issued, o.id, o.date) from Invoice i inner join Order o where i.issued < o.date ")
    List<WrongDateResponse> findAllWrongDateInvoices();

    @Query(value = "select i.id, (sum(p.amount) - i.amount) from invoices i " +
            "left join payments p on i.id = p.invoice_id " +
            "where p.id is not null group by i.id having i.amount < sum(p.amount)", nativeQuery = true)
    List<Object[]> findAllOverpaidInvoices();
}
