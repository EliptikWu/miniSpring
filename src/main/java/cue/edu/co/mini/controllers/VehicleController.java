package cue.edu.co.mini.controllers;

import cue.edu.co.mini.mapping.dtos.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cue.edu.co.mini.service.VehicleService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/get-vehicles")
    public List<VehicleDto> getAllVehicles() throws SQLException  {
        return vehicleService.getVehicle();
    }

    @DeleteMapping(value = "/delete-vehicles/{id}")
    public void removeVehicle(@PathVariable Long id) throws SQLException  {
        vehicleService.removeVehicle(id);
    }

    @PostMapping(value = "/add-vehicle")
    public void addVehicle(@RequestBody VehicleDto vehicle)  throws SQLException {
        vehicleService.addVehicle(vehicle);
    }
}
