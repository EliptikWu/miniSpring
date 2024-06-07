package service;

import domain.Vehicle;

import java.util.List;

public interface VehicleService {
        List<Vehicle> getVehicle();
        void removeVehicle(Long id);
        void addVehicle(Vehicle vehicle);
}

