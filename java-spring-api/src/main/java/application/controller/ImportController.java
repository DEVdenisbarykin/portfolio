package application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/import")
@Tag(name = "Import API", description = "Endpoints to Import different data sets.")
public class ImportController {
    @Operation(summary = "Import data sets via Excel.")
    @ApiResponse(responseCode = "200", description = "Import successful")
    @ApiResponse(responseCode = "400", description = "Invalid File or invalid formatting.")
    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> importFile(
            @RequestParam("file")
            @Parameter(description = "Excel-File (.xlsx or .xls)", required = true)
            MultipartFile file
    ) {
        return null;
    }


}
