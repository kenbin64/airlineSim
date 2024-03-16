package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "gate")
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gate_id")
    private Integer gateId;

    @Column(name = "terminal_id", nullable = false)
    private Integer terminalId;

    @Column(name = "number", nullable = false)
    private String number;
}
