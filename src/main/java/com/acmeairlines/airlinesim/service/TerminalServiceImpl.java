package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Terminal;
import com.acmeairlines.airlinesim.repository.TerminalRepository;
import com.acmeairlines.airlinesim.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalServiceImpl implements TerminalService {

    private final TerminalRepository terminalRepository;

    @Autowired
    public TerminalServiceImpl(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    @Override
    public Terminal saveTerminal(Terminal terminal) {
        return terminalRepository.save(terminal);
    }

    @Override
    public Optional<Terminal> findTerminalById(Integer id) {
        return terminalRepository.findById(id.longValue());
    }

    @Override
    public List<Terminal> findAllTerminals() {
        return terminalRepository.findAll();
    }

    @Override
    public void deleteTerminal(Integer id) {
        terminalRepository.deleteById(id.longValue());
    }
}
