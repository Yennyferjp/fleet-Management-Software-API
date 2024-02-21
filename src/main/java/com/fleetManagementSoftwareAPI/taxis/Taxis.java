package com.fleetManagementSoftwareAPI.taxis;

import com.fleetManagementSoftwareAPI.trajectories.Trajectories;
import jakarta.persistence.*;

import java.util.Set;

@Entity // permite que Spring Data JPA pueda manipular la tabla de la db
@Table(name = "taxis")
public class Taxis {
    @Id
    private Long id;
    private String plate;

    @OneToMany(
            mappedBy = "taxi",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Trajectories> trajectories;

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
