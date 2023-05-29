package ru.ilka.app.orderRestApi.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_dish")
class OrderDish extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private BigDecimal price;

}