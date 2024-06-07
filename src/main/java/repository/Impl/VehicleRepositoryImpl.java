package repository.Impl;

import domain.User;
import domain.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import repository.VehicleRepository;

import java.util.List;

@Repository
@Transactional
public class VehicleRepositoryImpl implements VehicleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Vehicle> listVehicle(){
        String query = "FROM vehicle";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeVehicle(Long id){
        Vehicle vehicle = entityManager.find(Vehicle.class, id);
        entityManager.remove(vehicle);
    }

    @Override
    public void addVehicle(Vehicle vehicle){
        entityManager.merge(vehicle);
    }
}