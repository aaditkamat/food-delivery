package com.foodpanda.fooddelivery.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Order {
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private UUID id;

    // We assume that only one user places a particular order
    // from the app even if that user is ordering
    // for multiple people
    @Getter
    @Setter
    private User user;

    @Getter
    @Setter
    private LocalDateTime dateOrdered;

    @Override
    public String toString() {
        return "Order[" +
                "id=" + id +
                ", user=" + user +
                ", dateOrdered=" + dateOrdered +
                ']';
    }
}
