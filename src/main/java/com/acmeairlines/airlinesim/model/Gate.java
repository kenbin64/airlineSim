package com.acmeairlines.airlinesim.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "gate")
public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gateId;

    @ManyToOne
    @JoinColumn(name = "terminal_id", nullable = false)
    private Terminal terminal;

    @Column(nullable = false)
    private String number;
}
