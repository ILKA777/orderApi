package ru.ilka.app.orderRestApi.model;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "status")
    private String status;

    @Column(name = "specialRequests")
    private String specialRequests;

    @CreatedDate
    @Column(name = "created_at")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updated;

}