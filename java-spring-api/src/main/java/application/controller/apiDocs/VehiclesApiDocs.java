package application.controller.apiDocs;

import application.exceptions.ErrorResponse;
import application.models.EngineType;
import application.models.Vehicle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VehiclesApiDocs {
    @Operation(
            summary = "Retrieve a specific vehicle filtered by id.",
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
    public Vehicle getVehicleById(@PathVariable("id") Long id);

    @Operation(
            summary = "Retrieve all vehicles filtered by specific engine type.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Vehicle found",
                            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Vehicle.class)))
                    )
            })
    public List<Vehicle> getVehiclesByEngineType(@PathVariable("engineType") EngineType engineType);

    @Operation(
            summary = "Retrieve all vehicles.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Vehicle found",
                            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Vehicle.class)))
                    )
            })
    public List<Vehicle> getVehicles();

    @Operation(
            summary = "Create a new vehicle in in-memory database.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Vehicle created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class))
                    )
            })
    public Vehicle createVehicle(@RequestBody Vehicle vehicle);
}
