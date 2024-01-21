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
public class Dish {
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private UUID id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    private String description;

    // A dish can be assigned to many categories
    @Getter
    @Setter
    private List<Category> categories;

    // A dish listing can have multiple photos
    @Getter
    @Setter
    private List<Photo> photos;

    @Override
    public String toString() {
        return "Product[" +
                "id=" + id +
                ", name='" + name +
                ", price=" + price +
                ", description='" + description +
                ", categories=" + categories.stream().map(Category::toString).collect(Collectors.joining()) +
                ", photos=" + photos.stream().map(Photo::toString).collect(Collectors.joining()) +
                "]";
    }
}
