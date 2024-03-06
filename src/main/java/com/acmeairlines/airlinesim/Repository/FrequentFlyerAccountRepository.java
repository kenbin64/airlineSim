package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.FrequentFlyerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrequentFlyerAccountRepository extends JpaRepository<FrequentFlyerAccount, Integer> {
}
