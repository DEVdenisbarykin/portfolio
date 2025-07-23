package application.controller.apiDocs;

import application.dtos.VehicleDto;
import application.entities.EngineType;
import application.exceptions.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface VehiclesApiDocs {
    @Operation(
            summary = "Retrieve a specific vehicle filtered by id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Vehicle found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = VehicleDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "4o4",
                            description = "Vehicle not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    )
            })
    public VehicleDto getVehicleById(@PathVariable("id") Long id);

    @Operation(
            summary = "Retrieve all vehicles.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Vehicles found",
                            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VehicleDto.class)))
                    )
            })
    public List<VehicleDto> getVehicles(@Parameter(description = "Filter vehicles by engine type") @RequestParam(required = false) EngineType engineType);

    @Operation(
            summary = "Create a new vehicle in in-memory database.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Vehicle created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = VehicleDto.class))
                    )
            })
    public VehicleDto createVehicle(@Valid @RequestBody VehicleDto vehicle);
}
