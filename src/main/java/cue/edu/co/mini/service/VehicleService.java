package cue.edu.co.mini.service;

import cue.edu.co.mini.mapping.dtos.VehicleDto;

import java.sql.SQLException;
import java.util.List;

public interface VehicleService {
        List<VehicleDto> getVehicle() throws SQLException;
        void removeVehicle(Long id) throws SQLException ;
        void addVehicle(VehicleDto vehicle) throws SQLException ;
        VehicleDto getVehicleById(Long id) throws SQLException ;
       /** List<VehicleDto> listVehicleByCategory(String type) throws SQLException ;
        List<VehicleDto> listVehicleByPrice(Double price) throws SQLException ;
        List<VehicleDto> listVehicleByAvailable(String available) throws SQLException ;***/
}

