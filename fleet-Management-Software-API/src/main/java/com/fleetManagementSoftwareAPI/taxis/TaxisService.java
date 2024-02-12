package com.fleetManagementSoftwareAPI.taxis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaxisService {

    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxisService(TaxiRepository taxiRepository){
        this.taxiRepository = taxiRepository;
    }

    public Page<Taxis> getTaxis(int initPage, int pageSize){
        Pageable pageNumber = PageRequest.of(initPage, pageSize);
        return taxiRepository.findAll(pageNumber);
    }
}

