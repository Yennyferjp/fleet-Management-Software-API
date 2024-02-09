package com.fleetManagementSoftwareAPI.trajectories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface TrajectoriesRepository extends JpaRepository<Trajectories, Long> {

    Page<Trajectories> findByTaxiIdAndDate(Long taxi_id, LocalDate date, Pageable page);
}

