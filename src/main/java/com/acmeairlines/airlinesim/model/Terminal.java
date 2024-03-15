package com.acmeairlines.airlinesim.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "terminal")
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer terminalId;

    private Integer airportId;
    private String name;

    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY)
    private List<Gate> gates;

    // Constructors, getters, and setters are omitted for brevity
}

