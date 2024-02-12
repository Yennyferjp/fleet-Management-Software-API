package com.fleetManagementSoftwareAPI.trajectories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TrajectoriesRepository extends JpaRepository<Trajectories, Long> {

    Page<Trajectories> findByTaxiIdAndDateGreaterThanEqualAndDateBefore(
            Long taxiId, LocalDate startDate, LocalDate endDate, Pageable pageable
    );
// >= 2008-02-02 AND date < 2008-02-03
}

