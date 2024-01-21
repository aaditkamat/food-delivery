package com.foodpanda.fooddelivery.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
public class Photo {
    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    private long hashCode;

    @Getter
    @Setter
    // Each photo is associated with only one product
    private Dish product;

    @Override
    public String toString() {
        return "Photo[" +
                "id=" + id +
                ", hashCode=" + hashCode +
                ", product=" + product +
                ']';
    }
}
