package com.fleetManagementSoftwareAPI.taxis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/taxis")
public class TaxisController {


    public final TaxisService taxisService;

    @Autowired
    public TaxisController(TaxisService taxisService){
        this.taxisService = taxisService;
    }

    @GetMapping()
    public Page<Taxis> getTaxis(@RequestParam(defaultValue = "0") int pageNumber,
                                @RequestParam(defaultValue = "10") int pageSize){
        return taxisService.getTaxis(pageNumber, pageSize);
    }

}
