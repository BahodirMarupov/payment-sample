package uz.bahodirsmind.paymentdemo.service;

import uz.bahodirsmind.paymentdemo.payload.response.NumberOfOrdersResponse;
import uz.bahodirsmind.paymentdemo.payload.response.OrdersWithoutInvoicesResponse;
import uz.bahodirsmind.paymentdemo.payload.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrdersWithoutDetails();

    List<NumberOfOrdersResponse> getNumberOfOrders();

    List<OrdersWithoutInvoicesResponse> getAllOrdersWithoutInvoices();
}
