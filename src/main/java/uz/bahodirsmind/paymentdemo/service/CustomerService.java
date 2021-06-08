package uz.bahodirsmind.paymentdemo.service;

import uz.bahodirsmind.paymentdemo.payload.response.CustomersLastOrdersResponse;
import uz.bahodirsmind.paymentdemo.payload.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomersWithoutOrders();

    List<CustomersLastOrdersResponse> getCustomersLastOrders();
}
