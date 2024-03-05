package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "passenger")
@Data
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerId;

    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "requires_passport", nullable = false)
    private boolean requiresPassport = false;

    // Assuming a relationship to FrequentFlyerAccount if needed
    @OneToOne
    private FrequentFlyerAccount frequentFlyerAccount;

    @ManyToMany
    @JoinTable(
            name = "passenger_passenger_type",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_type_id")
    )
    private Set<PassengerType> passengerTypes = new HashSet<>();
}
