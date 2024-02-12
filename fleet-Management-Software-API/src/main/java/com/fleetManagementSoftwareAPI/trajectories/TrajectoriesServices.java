package com.fleetManagementSoftwareAPI.trajectories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TrajectoriesServices {

    private final TrajectoriesRepository trajectoriesRepository;

    @Autowired
    public TrajectoriesServices(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }


        public Page<Trajectories> getTrajectories(Long taxi_id, LocalDateTime startDate, int initPage, int pageSize) {
            Pageable page = PageRequest.of(initPage, pageSize);
            LocalDateTime endDate = startDate.plusDays(1);
            return trajectoriesRepository.findByTaxiIdAndDateGreaterThanEqualAndDateBefore(taxi_id, startDate, endDate, page);
        }


}