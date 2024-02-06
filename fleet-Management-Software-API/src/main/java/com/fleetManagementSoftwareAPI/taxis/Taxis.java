package com.fleetManagementSoftwareAPI.taxis;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // permite que Spring Data JPA pueda manipular la tabla de la db
public class Taxis {
    @Id
    private Long id;
    private String plate;

    public Taxis() {
    }

    public Taxis(Long id,
                 String plate) {
        this.id = id;
        this.plate = plate;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Taxis{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                '}';
    }
}
