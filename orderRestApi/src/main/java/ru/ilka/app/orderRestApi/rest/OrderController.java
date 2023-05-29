package ru.ilka.app.orderRestApi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ilka.app.orderRestApi.dto.OrderDto;
import ru.ilka.app.orderRestApi.repository.OrderRepository;

import javax.persistence.criteria.Order;
import java.util.List;

@RestController
@RequestMapping("/orders")
class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {

        if (!isValidOrderDto(orderDto)) {
            return ResponseEntity.badRequest().body("Неверные данные заказа");
        }

        Order createdOrder = orderService.createOrder(orderDto);

        if (createdOrder != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Заказ успешно создан");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при создании заказа");
        }
    }

}