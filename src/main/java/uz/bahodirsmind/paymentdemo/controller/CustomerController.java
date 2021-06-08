package uz.bahodirsmind.paymentdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bahodirsmind.paymentdemo.payload.response.CustomersLastOrdersResponse;
import uz.bahodirsmind.paymentdemo.payload.dto.CustomerDTO;
import uz.bahodirsmind.paymentdemo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // N: 4
    @GetMapping("/customers_without_orders")
    public List<CustomerDTO> getAllCustomersWithoutOrders() {
        return customerService.getAllCustomersWithoutOrders();
    }

    // N: 5
    @GetMapping("/customers_last_orders")
    public List<CustomersLastOrdersResponse> getCustomersLastOrders() {
        return customerService.getCustomersLastOrders();
    }

}
