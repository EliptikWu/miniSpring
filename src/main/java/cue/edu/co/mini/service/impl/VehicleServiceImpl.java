package cue.edu.co.mini.service.impl;

import cue.edu.co.mini.mapping.dtos.VehicleDto;
import cue.edu.co.mini.mapping.mapper.UserMapper;
import cue.edu.co.mini.mapping.mapper.VehicleMapper;
import cue.edu.co.mini.repository.VehicleRepository;
import cue.edu.co.mini.service.VehicleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="https://github.com/EliptikWu"
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     * Retrieves a list of vehicles from the vehicle repository.
     *
     * @return a list of VehicleDto objects.
     */
    @Override
    public List<VehicleDto> getVehicle() throws SQLException {
        return vehicleRepository.findAll().stream()
                .map(VehicleMapper::mapFrom)
                .toList();
    }

    /**
     * Removes a vehicle from the vehicle repository based on the provided vehicle ID.
     *
     * @param id the ID of the vehicle to be removed.
     */
    @Override
    public void removeVehicle(Long id) throws SQLException {
        vehicleRepository.delete(VehicleMapper.mapFrom(getVehicleById(id)));
    }
    /**
     * Retrieves a  vehicle from the  vehicle repository based on the provided  vehicle ID.
     *
     * @param id the ID of the  vehicle to be retrieved.
     * @return an Optional containing the VehicleDto object if found, or an empty Optional if not found.
     */
    @Override
    public VehicleDto getVehicleById(Long id) throws SQLException {
        return vehicleRepository.findById(id)
                .map(VehicleMapper::mapFrom)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    /**
     * Adds a new vehicle to the vehicle repository.
     *
     * @param vehicle the VehicleDto object to be added.
     */
    @Override
    public void addVehicle(VehicleDto vehicle) throws SQLException {
        vehicleRepository.save(VehicleMapper.mapFrom(vehicle));
    }

    /**
     * Retrieves a list of vehicles from the vehicle repository filtered by the specified category.
     *
     * @param type the category type of the vehicles to retrieve.
     * @return a list of VehicleDto objects that belong to the specified category.
     */
   /** @Override
    public List<VehicleDto> listVehicleByCategory(String type) throws SQLException {
        return vehicleRepository.listVehicleByCategory().stream()
                .filter(vehicle -> vehicle.type().equals(type))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of vehicles from the vehicle repository filtered by the specified price.
     *
     * @param price the price of the vehicles to retrieve.
     * @return a list of VehicleDto objects that match the specified price.
     */
   /** @Override
    public List<VehicleDto> listVehicleByPrice(Double price) throws SQLException {
        return vehicleRepository.listVehicleByCategory().stream()
                .filter(vehicle -> vehicle.type().equals(price))
                .collect(Collectors.toList());
    }
    /**
     * Retrieves a list of vehicles from the vehicle repository filtered by availability.
     *
     * @param available the availability status of the vehicles to retrieve.
     *                  It should be "true" for available vehicles and "false" for unavailable vehicles.
     * @return a list of VehicleDto objects that match the specified availability status.
     */
   /** @Override
    public List<VehicleDto> listVehicleByAvailable(String available) throws SQLException {
        return vehicleRepository.listVehicleByCategory().stream()
                .filter(vehicle -> vehicle.type().equals(available))
                .collect(Collectors.toList());
    }**/

}