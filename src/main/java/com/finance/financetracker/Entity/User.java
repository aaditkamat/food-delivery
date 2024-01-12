package com.finance.financetracker.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;


@Table(name = "users")  // "user" is a reserved keyword in SQL
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private UUID user_id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String username;

    @Setter
    private LocalDateTime dateJoined;

    @Override
    public String toString() {
        return "User[" +
                "user_id=" + user_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", date_joined=" + dateJoined +
                ']';
    }
}
