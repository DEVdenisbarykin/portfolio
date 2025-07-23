package application.services;

import application.dtos.VehicleDto;
import application.entities.EngineType;
import application.entities.Vehicle;
import application.exceptions.DuplicateVehicleException;
import application.repositories.VehicleRepository;
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
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Vehicle with id %d does not exist.", id)));
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public void deleteVehicle(Long id) {
        Vehicle vehicle = this.getVehicleById(id);
        vehicleRepository.delete(vehicle);
    }

    public VehicleDto updateVehicle(Long id, VehicleDto vehicleDto) {
        Vehicle existingVehicle = this.getVehicleById(id);

        existingVehicle.setVehicleType(vehicleDto.getVehicleType());
        existingVehicle.setBrand(vehicleDto.getBrand());
        existingVehicle.setModel(vehicleDto.getModel());
        existingVehicle.setEngineType(vehicleDto.getEngineType());

        Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
        return updatedVehicle.toDto();
    }

    public VehicleDto patchVehicle(Long id, VehicleDto vehicleDto) {
        Vehicle existingVehicle = this.getVehicleById(id);

        if (vehicleDto.getVehicleType() != null) {
            existingVehicle.setVehicleType(vehicleDto.getVehicleType());
        }

        if (vehicleDto.getBrand() != null) {
            existingVehicle.setBrand(vehicleDto.getBrand());
        }

        if (vehicleDto.getModel() != null) {
            existingVehicle.setModel(vehicleDto.getModel());
        }

        if (vehicleDto.getEngineType() != null) {
            existingVehicle.setEngineType(vehicleDto.getEngineType());
        }

        Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
        return updatedVehicle.toDto();
    }
}
