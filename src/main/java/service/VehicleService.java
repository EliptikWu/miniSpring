package service;

import mapping.dtos.VehicleDto;
import java.util.List;
import java.util.Optional;

public interface VehicleService {
        List<VehicleDto> getVehicle();
        void removeVehicle(Long id);
        void addVehicle(VehicleDto vehicle);
        Optional<VehicleDto> getVehicleById(Long id);
        void saveVehicle(VehicleDto vehicle);
        List<VehicleDto> listVehicleByCategory(String type);
        List<VehicleDto> listVehicleByPrice(Double price);
        List<VehicleDto> listVehicleByAvailable(String available);
}

