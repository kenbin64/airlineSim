package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {
}
