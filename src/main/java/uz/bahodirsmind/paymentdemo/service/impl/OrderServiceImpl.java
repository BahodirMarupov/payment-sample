package uz.bahodirsmind.paymentdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uz.bahodirsmind.paymentdemo.domain.Order;
import uz.bahodirsmind.paymentdemo.payload.enums.Countries;
import uz.bahodirsmind.paymentdemo.payload.response.NumberOfOrdersResponse;
import uz.bahodirsmind.paymentdemo.payload.response.OrdersWithoutInvoicesResponse;
import uz.bahodirsmind.paymentdemo.payload.dto.OrderDTO;
import uz.bahodirsmind.paymentdemo.repository.OrderRepository;
import uz.bahodirsmind.paymentdemo.service.OrderService;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDTO> getAllOrdersWithoutDetails() {
        return orderRepository.findAllOrdersWithoutDetails().stream().map(Order::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<NumberOfOrdersResponse> getNumberOfOrders() {
        List<NumberOfOrdersResponse> numberOfOrders = new ArrayList<>();
        try {
            final var objects = orderRepository.findNumberOfOrders();
            for (Object[] object : objects) {
                numberOfOrders.add(new NumberOfOrdersResponse(
                        object[0] != null ? Countries.valueOf(object[0].toString()).name : "",
                        object[1] != null ? Integer.parseInt(object[1].toString()) : null
                ));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return numberOfOrders;
    }

    @Override
    public List<OrdersWithoutInvoicesResponse> getAllOrdersWithoutInvoices() {
        List<OrdersWithoutInvoicesResponse> ordersWithoutInvoices = new ArrayList<>();
        try {
            final var objects = orderRepository.findAllOrdersWithoutInvoices();
            for (Object[] object : objects) {
                ordersWithoutInvoices.add(new OrdersWithoutInvoicesResponse(
                        object[0] != null ? Long.parseLong(object[0].toString()) : null,
                        object[1] != null ? (Data) object[1] : null,
                        object[2] != null ? new BigDecimal(object[2].toString()) : null
                ));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return ordersWithoutInvoices;
    }
}
