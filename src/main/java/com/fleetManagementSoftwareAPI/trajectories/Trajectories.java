package com.fleetManagementSoftwareAPI.trajectories;

import com.fleetManagementSoftwareAPI.taxis.Taxis;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity (name = "trajectories")
public class Trajectories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long taxi_id;
    private LocalDateTime date;
    private double latitude;
    private double longitude;



    @ManyToOne
    @JoinColumn(name = "taxi_id", insertable = false, updatable = false)
    private Taxis taxi;


    public Trajectories() {
    }

    public Taxis getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxis taxi) {
        this.taxi = taxi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


}
