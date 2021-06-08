package uz.bahodirsmind.paymentdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uz.bahodirsmind.paymentdemo.domain.Invoice;
import uz.bahodirsmind.paymentdemo.payload.response.OverpaidInvoicesResponse;
import uz.bahodirsmind.paymentdemo.payload.response.WrongDateResponse;
import uz.bahodirsmind.paymentdemo.payload.dto.InvoiceDTO;
import uz.bahodirsmind.paymentdemo.repository.InvoiceRepository;
import uz.bahodirsmind.paymentdemo.service.InvoiceService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<InvoiceDTO> getAllExpiredInvoices() {
        return invoiceRepository.findAllExpiredInvoices().stream().map(Invoice::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<WrongDateResponse> getAllWrongDateInvoices() {
        return invoiceRepository.findAllWrongDateInvoices();
    }

    @Override
    public List<OverpaidInvoicesResponse> getAllOverpaidInvoices() {
        List<OverpaidInvoicesResponse> overpaidInvoices = new ArrayList<>();
        try {
            final var objects = invoiceRepository.findAllOverpaidInvoices();
            for (Object[] object : objects) {
                overpaidInvoices.add(new OverpaidInvoicesResponse(
                        object[0] != null ? Long.valueOf(object[0].toString()) : null,
                        object[1] != null ? new BigDecimal(object[1].toString()) : null
                ));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return overpaidInvoices;
    }
}
