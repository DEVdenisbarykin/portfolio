package application.services;

import application.repositories.VehicleRepository;
import application.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles.forEach(vehicle -> System.out.println(vehicle.toString()));
        return vehicles;
    }
}
