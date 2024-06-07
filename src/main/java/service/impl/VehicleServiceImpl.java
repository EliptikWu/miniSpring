package service.impl;

import domain.User;
import domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;
import repository.VehicleRepository;
import service.VehicleService;


import java.util.List;

@org.springframework.stereotype.Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getVehicle(){
        return vehicleRepository.listVehicle();
    }
    @Override
    public void removeVehicle(Long id){
        vehicleRepository.removeVehicle(id);
    }

    @Override
    public void addVehicle(Vehicle vehicle){
        vehicleRepository.addVehicle(vehicle);
    }
}