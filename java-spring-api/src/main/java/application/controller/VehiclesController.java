package application.controller;

import application.controller.apiDocs.VehiclesApiDocs;
import application.dtos.VehicleDto;
import application.entities.EngineType;
import application.entities.Vehicle;
import application.services.VehicleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    public VehicleDto getVehicleById(@PathVariable("id") Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return vehicle.toDto();
    }

    @Override
    @GetMapping
    public List<VehicleDto> getVehicles(@RequestParam(required = false) EngineType engineType) {
        List<Vehicle> vehicles;
        if (engineType != null) {
            vehicles = vehicleService.getVehiclesByEngineType(engineType);
        } else {
            vehicles = vehicleService.getVehicles();
        }

        return vehicles.stream()
                .map(Vehicle::toDto)
                .toList();
    }

    @Override
    @PostMapping
    public VehicleDto createVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleService.createVehicle(vehicleDto.toEntity());
        return vehicle.toDto();
    }

    @Override
    @DeleteMapping("{id}")
    public void deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteVehicle(id);
    }

    @Override
    @PutMapping("{id}")
    public VehicleDto putVehicle(@PathVariable("id") Long id, @Valid @RequestBody VehicleDto vehicleDto) {
        return vehicleService.updateVehicle(id, vehicleDto);
    }

    @Override
    @PatchMapping("{id}")
    public VehicleDto patchVehicle(@PathVariable("id") Long id, @RequestBody VehicleDto vehicleDto) {
        return vehicleService.patchVehicle(id, vehicleDto);
    }
}
