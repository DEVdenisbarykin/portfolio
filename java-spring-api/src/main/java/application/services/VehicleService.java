package application.services;

import application.entities.EngineType;
import application.entities.Vehicle;
import application.exceptions.DuplicateVehicleException;
import application.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        Optional<Vehicle> existingVehicle = vehicleRepository.findByModelAndBrandAndEngineType(vehicle.getModel(), vehicle.getBrand(), vehicle.getEngineType());

        if (existingVehicle.isPresent()) {
            throw new DuplicateVehicleException(String.format("Vehicle %s %s with engine %s already exists.", vehicle.getModel(), vehicle.getBrand(), vehicle.getEngineType()));
        }

        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getVehiclesByEngineType(EngineType engineType) {
        return vehicleRepository.findByEngineType(engineType);
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).get();
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }
}
