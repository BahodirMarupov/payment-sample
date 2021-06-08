package uz.bahodirsmind.paymentdemo.service;

import uz.bahodirsmind.paymentdemo.payload.response.OverpaidInvoicesResponse;
import uz.bahodirsmind.paymentdemo.payload.response.WrongDateResponse;
import uz.bahodirsmind.paymentdemo.payload.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDTO> getAllExpiredInvoices();

    List<WrongDateResponse> getAllWrongDateInvoices();

    List<OverpaidInvoicesResponse> getAllOverpaidInvoices();
}
