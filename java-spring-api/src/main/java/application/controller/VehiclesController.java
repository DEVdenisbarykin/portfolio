package application.controller;

import application.controller.apiDocs.VehiclesApiDocs;
import application.models.EngineType;
import application.models.Vehicle;
import application.services.VehicleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicles")
@Tag(name = "Vehicles API", description = "Endpoints for managing vehicle data, including creation, retrieval," +
        " updating, and deletion of vehicle records.")
public class VehiclesController implements VehiclesApiDocs {
    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    @GetMapping("{id}")
    public Vehicle getVehicleById(@PathVariable("id") Long id) {
        return vehicleService.getVehicleById(id);
    }

    @Override
    @GetMapping("{engineType}")
    public List<Vehicle> getVehiclesByEngineType(@PathVariable("engineType") EngineType engineType) {
        return vehicleService.getVehiclesByEngineType(engineType);
    }

    @Override
    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @Override
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }
}
