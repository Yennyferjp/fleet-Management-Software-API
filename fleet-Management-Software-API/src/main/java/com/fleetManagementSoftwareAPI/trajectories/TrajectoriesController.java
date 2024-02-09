package com.fleetManagementSoftwareAPI.trajectories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@RestController
@RequestMapping(path = "/trajectories")
public class TrajectoriesController {

    private final TrajectoriesServices trajectoriesServices;

    @Autowired
    public TrajectoriesController(TrajectoriesServices trajectoriesServices){
        this.trajectoriesServices = trajectoriesServices;
    }

    @GetMapping()
    public Page<Trajectories> getTrajectories(@RequestParam Long taxi_id,
                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                              @RequestParam(defaultValue = "0") int initPage,
                                              @RequestParam(defaultValue = "10") int pageSize) {

        return trajectoriesServices.getTrajectories(taxi_id, date, initPage, pageSize);
    }




}
