package repository;

import domain.User;
import domain.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> listVehicle();
    void removeVehicle(Long id);
    void addVehicle(Vehicle vehicle);
}

