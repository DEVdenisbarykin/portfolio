package application.entities;

import application.dtos.VehicleDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private String brand;
    private String model;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    public VehicleDto toDto() {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setVehicleType(this.getVehicleType());
        vehicleDto.setBrand(this.getBrand());
        vehicleDto.setModel(this.getModel());
        vehicleDto.setFullName(this.getBrand() + " " + this.getModel());
        vehicleDto.setEngineType(this.getEngineType());
        return vehicleDto;
    }
}
