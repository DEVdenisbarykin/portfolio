package application.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private VehicleType vehicleType;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String brand;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String model;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EngineType engineType;

}
