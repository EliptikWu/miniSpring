package service;

import domain.Vehicle;
import mapping.dtos.VehicleDto;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
        List<Vehicle> getVehicle();
        void removeVehicle(Long id);
        void addVehicle(Vehicle vehicle);
        Optional<Vehicle> getVehicleById(Long id);
        void saveVehicle(Vehicle vehicle);
}

