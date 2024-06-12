package repository;

import domain.User;
import domain.Vehicle;
import mapping.dtos.VehicleDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> listVehicle();
    void removeVehicle(Long id);
    void addVehicle(Vehicle vehicle);
    Optional<Vehicle>  getVehicleById(Long id);
    void saveVehicle(Vehicle vehicle);
}

