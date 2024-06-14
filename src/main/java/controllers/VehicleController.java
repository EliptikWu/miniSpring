package controllers;

import domain.Vehicle;
import mapping.dtos.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.VehicleService;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/get-vehicles")
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.getVehicle();
    }

    @DeleteMapping(value = "/delete-vehicles/{id}")
    public void removeVehicle(@PathVariable Long id) {
        vehicleService.removeVehicle(id);
    }

    @PostMapping(value = "/add-vehicle")
    public void addVehicle(@RequestBody VehicleDto vehicle) {
        vehicleService.addVehicle(vehicle);
    }
}
