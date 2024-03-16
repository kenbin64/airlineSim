package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Terminal;

import java.util.List;
import java.util.Optional;

public interface TerminalService {
    Terminal saveTerminal(Terminal terminal);
    Optional<Terminal> findTerminalById(Integer id);
    List<Terminal> findAllTerminals();
    void deleteTerminal(Integer id);
}
