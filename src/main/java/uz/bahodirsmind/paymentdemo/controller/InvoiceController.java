package uz.bahodirsmind.paymentdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bahodirsmind.paymentdemo.payload.response.OverpaidInvoicesResponse;
import uz.bahodirsmind.paymentdemo.payload.response.WrongDateResponse;
import uz.bahodirsmind.paymentdemo.payload.dto.InvoiceDTO;
import uz.bahodirsmind.paymentdemo.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // N: 1
    @GetMapping("/expired_invoices")
    public List<InvoiceDTO> getAllExpiredInvoices() {
        return invoiceService.getAllExpiredInvoices();
    }

    // N: 2
    @GetMapping("/wrong_date_invoices")
    public List<WrongDateResponse> getAllWrongDateInvoices() {
        return invoiceService.getAllWrongDateInvoices();
    }

    // N: 6
    @GetMapping("/overpaid_invoices")
    public List<OverpaidInvoicesResponse> getAllOverpaidInvoices(){
        return invoiceService.getAllOverpaidInvoices();
    }
}
