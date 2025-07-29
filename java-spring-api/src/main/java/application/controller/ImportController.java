package application.controller;

import application.entities.EngineType;
import application.entities.Vehicle;
import application.entities.VehicleType;
import application.exceptions.ImportException;
import application.services.ImportService;
import application.services.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/import")
@Tag(name = "Import API", description = "Endpoints to Import different data sets.")
public class ImportController {
    private final ImportService importService;
    private final VehicleService vehicleService;

    public ImportController(ImportService importService, VehicleService vehicleService) {
        this.importService = importService;
        this.vehicleService = vehicleService;
    }

    @Operation(summary = "Import data sets via Excel.")
    @ApiResponse(responseCode = "200", description = "Import successful")
    @ApiResponse(responseCode = "400", description = "Invalid File or invalid formatting.")
    @ApiResponse(responseCode = "422", description = "Import not possible due to invalid values in excel file.")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void importFile(
            @RequestParam("file")
            @Parameter(description = "Excel-File (.xlsx or .xls)", required = true)
            MultipartFile file
    ) throws IOException {
        Workbook workbook = importService.openExcelFile(file);
        List<List<String>> excelData = importService.getValuesFromCells(workbook);

        try {
            excelData.forEach(vehicleData -> {
                String brand = vehicleData.get(0);
                String model = vehicleData.get(1);
                VehicleType vehicleType = VehicleType.valueOf(vehicleData.get(2).toUpperCase());
                EngineType engineType = EngineType.valueOf(vehicleData.get(3).toUpperCase());

                Vehicle vehicle = new Vehicle(brand, model, vehicleType, engineType);
                vehicleService.createVehicle(vehicle);
            });
        } catch (Exception e) {
            throw new ImportException(e.getMessage());
        }
    }
}
