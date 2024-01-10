package com.example.lab2.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;


@Getter
@Entity
@Setter
@NoArgsConstructor
@ToString
@Table(name = "creditcard")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer cardId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "cvv")
    private String cvv;
}
