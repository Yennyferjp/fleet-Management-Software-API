package com.fleetManagementSoftwareAPI.trajectories;

import com.fleetManagementSoftwareAPI.taxis.Taxis;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity (name = "trajectories")
public class Trajectories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long taxi_id;
    private LocalDate date;
    private double latitude;
    private double longitude;
    @ManyToOne
    @JoinColumn(name = "taxi_id", insertable = false, updatable = false)
    private Taxis taxi;

    public Trajectories() {
    }

    public Trajectories(Long id, Long taxi_id, LocalDate date, double latitude, double longitude, Taxis taxi) {
        this.id = id;
        this.taxi_id = taxi_id;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.taxi = taxi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(Long taxi_id) {
        this.taxi_id = taxi_id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Trajectories{" +
                "id=" + id +
                ", date=" + date +
                ", taxi_id=" + taxi_id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
