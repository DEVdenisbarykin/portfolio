package application.repositories;

import application.entities.EngineType;
import application.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByModelAndBrandAndEngineType(String model, String brand, EngineType engineType);

    List<Vehicle> findByEngineType(EngineType engineType);
}
