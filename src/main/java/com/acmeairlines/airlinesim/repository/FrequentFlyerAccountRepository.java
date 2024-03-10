package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.FrequentFlyerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequentFlyerAccountRepository extends JpaRepository<FrequentFlyerAccount, Integer> {
    // Define any custom query methods here
}