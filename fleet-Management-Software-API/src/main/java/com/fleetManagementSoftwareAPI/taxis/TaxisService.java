package com.fleetManagementSoftwareAPI.taxis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxisService {

    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxisService(TaxiRepository taxiRepository){
        this.taxiRepository = taxiRepository;
    }

    public List<Taxis> getTaxis(){
        return taxiRepository.findAll();
    }

}

