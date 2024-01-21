package com.foodpanda.fooddelivery.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Table(name = "users")  // "user" is a reserved keyword in SQL
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private UUID id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String fullName;

    @Setter
    @Getter
    private String role;

    @Setter
    @Getter
    private long phone;

    // One user can place several orders on the app
    @Setter
    @Getter
    private List<Order> orders;

    @Override
    public String toString() {
        return "User[" +
                "id=" + id +
                ", email='" + email +
                ", password='" + password +
                ", full name='" + fullName +
                ", role=" + role +
                ", orders=" + orders.stream().map(Order::toString).collect(Collectors.joining()) +
                ']';
    }
}
