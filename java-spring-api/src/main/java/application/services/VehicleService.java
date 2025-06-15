package application.services;

import application.repositories.VehicleRepository;
import application.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(Long id) throws NoSuchElementException {
        return vehicleRepository.findById(id).get();
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }
}
