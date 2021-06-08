package uz.bahodirsmind.paymentdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bahodirsmind.paymentdemo.payload.response.NumberOfOrdersResponse;
import uz.bahodirsmind.paymentdemo.payload.response.OrdersWithoutInvoicesResponse;
import uz.bahodirsmind.paymentdemo.payload.dto.OrderDTO;
import uz.bahodirsmind.paymentdemo.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // N: 3
    @GetMapping("/orders_without_details")
    public List<OrderDTO> getAllOrdersWithoutDetails() {
        return orderService.getAllOrdersWithoutDetails();
    }

    // N: 9
    @GetMapping("/number_of_orders_in_year")
    public List<NumberOfOrdersResponse> getNumberOfOrders(){
        return orderService.getNumberOfOrders();
    }

    // N: 10
    @GetMapping("/orders_without_invoices")
    public List<OrdersWithoutInvoicesResponse> getAllOrdersWithoutInvoices(){
        return orderService.getAllOrdersWithoutInvoices();
    }
}
