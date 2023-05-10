package co.com.bancolombia.api.utility;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseExceptionDTO {
    private Response response;
    private HttpStatus httpStatus;

    public ResponseExceptionDTO(Response response, HttpStatus httpStatus) {
        this.response = response;
        this.httpStatus = httpStatus;
    }
}
