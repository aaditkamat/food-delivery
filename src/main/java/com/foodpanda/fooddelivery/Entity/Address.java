package com.foodpanda.fooddelivery.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
public class Address {
    @Getter
    @Setter
    private UUID id;

    // There is a one-to-one relationship between
    // user and address because the user can set only
    // one address for delivery and only one user is ordering
    // at a particular address
    @Getter
    @Setter
    private User user;

    @Getter
    @Setter
    private String street;

    // We assume that users are only collecting from their blocks
    // so you don't need to specify the unit number
    private String block;

    @Getter
    @Setter
    private long zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", user=" + user +
                ", street='" + street + '\'' +
                ", block='" + block + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
