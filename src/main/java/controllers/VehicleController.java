package controllers;

import domain.User;
import domain.Vehicle;
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
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getVehicle();
    }

    @DeleteMapping(value = "/delete-vehicles/{id}")
    public void removeVehicle(@PathVariable Long id) {
        vehicleService.removeVehicle(id);
    }

    @PostMapping(value = "/add-vehicle")
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
    }
}
