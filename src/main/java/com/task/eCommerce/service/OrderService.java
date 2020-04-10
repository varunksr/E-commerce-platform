package com.task.eCommerce.service;

import com.task.eCommerce.domain.Item;
import com.task.eCommerce.domain.Order;
import com.task.eCommerce.dto.OrderDetailDTO;
import com.task.eCommerce.repository.ItemRepository;
import com.task.eCommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository,
                        ItemRepository itemRepository){
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public Order placeSingleOrder(OrderDetailDTO orderDetailDTO) throws Exception {
        Item item = itemRepository.findByItemCode(orderDetailDTO.getItemCode())
                .orElseThrow(() -> new IllegalArgumentException("No Item present with Item Code"));

        if(item.getInStock() == 0){
            throw new Exception("Item is out of stock");
        }

        if(orderDetailDTO.getQuantity() > item.getInStock()){
            throw new Exception("Requested quantity is not available," +
                    "available quantity for itemCode = "+item.getItemCode()+" is quantity= "+item.getInStock());
        }

        Order order = mapToOrder(orderDetailDTO, item);
        Order placedOrder = orderRepository.save(order);
        item.setInStock(item.getInStock() - placedOrder.getQuantity());
        itemRepository.save(item);
        return placedOrder;
    }

    public List<Order> placeBulkOrder(List<OrderDetailDTO> orderDetailList) throws Exception {
        List<Order> orders = new ArrayList<>();
        for(OrderDetailDTO o : orderDetailList){
            orders.add(placeSingleOrder(o));
        }
        return orders;
    }

    private Order mapToOrder(OrderDetailDTO orderDetailDTO, Item item) throws Exception {

        Order order = new Order();
        order.setEmailId(orderDetailDTO.getEmailId());
        order.setItemCode(orderDetailDTO.getItemCode());
        order.setQuantity(orderDetailDTO.getQuantity());
        order.setOrderId(UUID.randomUUID().toString());
        order.setPrice(item.getPrice() * orderDetailDTO.getQuantity());

        return order;
    }
}
