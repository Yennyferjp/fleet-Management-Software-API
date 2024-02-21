package com.fleetManagementSoftwareAPI.trajectories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface TrajectoriesRepository extends JpaRepository<Trajectories, Long> {
    //@Query("SELECT t FROM Trajectories t WHERE t.taxi_id = ?1 AND t.date <= ?2 ORDER BY t.date DESC")

    Page<Trajectories> findByTaxiIdAndDateGreaterThanEqualAndDateBeforeOrderByDateDesc(
            Long taxiId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable
    );
// >= 2008-02-02 AND date < 2008-02-03
@Query("SELECT t FROM trajectories t WHERE (t.taxi_id, t.date) IN (SELECT t2.taxi_id, MAX(t2.date) FROM trajectories t2 GROUP BY t2.taxi_id")
Page<Trajectories> findLastTrajectories(Pageable pageable);
}
