package com.fleetManagementSoftwareAPI.taxis;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxis, Id> {

}
