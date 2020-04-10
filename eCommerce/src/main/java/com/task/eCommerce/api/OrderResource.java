package com.task.eCommerce.api;


import com.task.eCommerce.domain.Order;
import com.task.eCommerce.dto.OrderDetailDTO;
import com.task.eCommerce.repository.OrderRepository;
import com.task.eCommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/order")
public class OrderResource {

    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public OrderResource(OrderRepository orderRepository,
                         OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping("{orderId}")
    public Order getOrderDetails(@PathVariable String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("No order present with orderId"));
    }

    @PostMapping("placeOrder")
    public Order placeSingleOrder(OrderDetailDTO orderDetailDTO) throws Exception {
        return orderService.placeSingleOrder(orderDetailDTO);
    }

    @PostMapping("placeBulkOrder")
    public List<Order> placeBulkOrder(List<OrderDetailDTO> orderList) throws Exception {
        return orderService.placeBulkOrder(orderList);
    }
}
