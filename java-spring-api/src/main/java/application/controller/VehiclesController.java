package application.controller;

import application.exceptions.ErrorResponse;
import application.models.Vehicle;
import application.services.VehicleService;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicles")
@Tag(name = "Vehicles API", description = "Endpoints for managing vehicle data, including creation, retrieval," +
        " updating, and deletion of vehicle records.")
public class VehiclesController {
    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Retrieve a specific vehicle from in-memory database by its id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Vehicle found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class))
                    ),
                    @ApiResponse(
                            responseCode = "4o4",
                            description = "Vehicle not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    )
            })
    public Vehicle getVehicleById(@Parameter(description = "ID of the vehicle to retrieve") @PathVariable("id") Long id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping
    @Operation(summary = "Retrieve all vehicles from in-memory database.")
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @PostMapping
    @Operation(summary = "Create a new vehicle in in-memory database.")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }
}
