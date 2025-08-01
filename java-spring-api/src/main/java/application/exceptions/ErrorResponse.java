package application.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private int status;
    private String error;
    private String errorMessage;
    private String errorClass;
    private Map<String, String> uniqueErrorMessages;

    public ErrorResponse(int status, String error, String errorClass, String errorMessage) {
        this.status = status;
        this.error = error;
        this.errorClass = errorClass;
        this.errorMessage = errorMessage;
    }

    public ErrorResponse(int status, String error, String errorClass, Map<String, String> uniqueErrorMessages) {
        this.status = status;
        this.error = error;
        this.errorClass = errorClass;
        this.uniqueErrorMessages = uniqueErrorMessages;
    }

}
