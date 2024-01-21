package com.foodpanda.fooddelivery.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
public class Category {
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Getter
    @Setter
    private String name;

    // One category can have several
    // different products listed under it
    @Getter
    @Setter
    private List<Dish> dishes;

    @Override
    public String toString() {
        return "Category[" +
                "id=" + id +
                ", name=" + name +
                ", dishes=" + dishes.stream().map(Dish::toString).collect(Collectors.joining()) +
                ']';
    }
}
