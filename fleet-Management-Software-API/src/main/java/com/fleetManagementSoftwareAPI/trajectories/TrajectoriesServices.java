package com.fleetManagementSoftwareAPI.trajectories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class TrajectoriesServices {

    private final TrajectoriesRepository trajectoriesRepository;

    @Autowired
    public TrajectoriesServices(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }

    public Page<Trajectories> getTrajectories(Long taxi_id, LocalDate date, int initPage, int pageSize) {
        Pageable page = PageRequest.of(initPage, pageSize);
        return trajectoriesRepository.findByTaxiIdAndDate(taxi_id, date, page);

    }
}