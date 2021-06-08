package uz.bahodirsmind.paymentdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uz.bahodirsmind.paymentdemo.domain.Customer;
import uz.bahodirsmind.paymentdemo.payload.response.CustomersLastOrdersResponse;
import uz.bahodirsmind.paymentdemo.payload.dto.CustomerDTO;
import uz.bahodirsmind.paymentdemo.repository.CustomerRepository;
import uz.bahodirsmind.paymentdemo.service.CustomerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomersWithoutOrders() {
        return customerRepository.findAllCustomersWithoutOrders().stream().map(Customer::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomersLastOrdersResponse> getCustomersLastOrders() {
        List<CustomersLastOrdersResponse> customersLastOrders = new ArrayList<>();
        try {
            final var objects = customerRepository.findCustomersLastOrders();
            for (Object[] object : objects) {
                customersLastOrders.add(new CustomersLastOrdersResponse(
                        object[0] != null ? Long.valueOf(object[0].toString()) : null,
                        object[1] != null ? object[1].toString() : "",
                        object[2] != null ? (Date) object[2] : null
                ));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return customersLastOrders;
    }
}
