package application.dtos;

import application.entities.EngineType;
import application.entities.Vehicle;
import application.entities.VehicleType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "VehicleType must be provided.")
    private VehicleType vehicleType;
    @NotNull(message = "Brand must be provided.")
    private String brand;
    @NotNull(message = "Model must be provided.")
    private String model;
    private String fullName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "EngineType must be provided.")
    private EngineType engineType;


    public Vehicle toEntity() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(this.getVehicleType());
        vehicle.setBrand(this.getBrand());
        vehicle.setModel(this.getModel());
        vehicle.setEngineType(this.getEngineType());
        return vehicle;
    }
}
