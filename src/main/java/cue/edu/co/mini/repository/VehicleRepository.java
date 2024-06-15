package cue.edu.co.mini.repository;

import cue.edu.co.mini.domain.Vehicle;
import cue.edu.co.mini.mapping.dtos.VehicleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
   /**List<VehicleDto> listVehicle();
    void removeVehicle(Long id);
    void addVehicle(VehicleDto vehicle);
    Optional<VehicleDto>  getVehicleById(Long id);
    void saveVehicle(VehicleDto vehicle);
    List<VehicleDto> listVehicleByCategory();
    List<VehicleDto> listVehicleByPrice(Double price);
    List<VehicleDto> listVehicleByAvailable(String available);
    List<VehicleDto> listVehicleByCategory();**/
}

