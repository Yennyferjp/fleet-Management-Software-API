package com.fleetManagementSoftwareAPI.trajectories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TrajectoriesRepository extends JpaRepository<Trajectories, Long> {
    //@Query("SELECT t FROM Trajectories t WHERE t.taxi_id = ?1 AND t.date <= ?2 ORDER BY t.date DESC")

    Page<Trajectories> findByTaxiIdAndDateGreaterThanEqualAndDateBeforeOrderByDateDesc(
            Long taxiId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable
    );
// >= 2008-02-02 AND date < 2008-02-03
@Query(value = "SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE  \n" +
        "            FROM (\n" +
        "            SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE, \n" +
        "            ROW_NUMBER() OVER (PARTITION BY TAXI_ID ORDER BY date DESC) as row_num \n" +
        "            FROM  trajectories) AS ranked \n" +
        "            WHERE row_num = 1", nativeQuery = true)
List<Trajectories> findLastTrajectories(Pageable pageable);
}

