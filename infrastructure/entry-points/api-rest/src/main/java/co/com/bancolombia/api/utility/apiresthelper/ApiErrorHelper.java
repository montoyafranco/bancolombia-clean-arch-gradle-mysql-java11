package co.com.bancolombia.api.utility.apiresthelper;

import co.com.bancolombia.api.utility.BusinessException;
import co.com.bancolombia.api.utility.Response;
import co.com.bancolombia.api.utility.ResponseExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.sql.SQLException;

@Controller
public class ApiErrorHelper {
    public ResponseExceptionDTO getErrorMessageInternal(Exception exception) {
        Response response = new Response();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        response.error = true;
        response.message = exception.getMessage();
        response.data = exception.getCause();

        return new ResponseExceptionDTO(response,httpStatus);
    }

//    protected ResponseExceptionDTO getErrorMessageForResponse(DataAccessException dataException) {
//        Response response = new Response();
//        HttpStatus httpStatus;
//        response.error = true;
//
//        if(dataException.getRootCause() instanceof SQLException sqlEx) {
//            var sqlErrorCode = sqlEx.getErrorCode();
//            switch (sqlErrorCode) {
//                case 1062 -> response.message = "The data is registered already.";
//                case 1452 -> response.message = "The indicated speciality/patient does not exist.";
//                case 1451 -> response.message = "Deletion denied";
//                default -> {
//                    response.message = dataException.getMessage();
//                    response.data = dataException.getCause();
//                }
//            }
//            httpStatus = HttpStatus.BAD_REQUEST;
//        } else {
//            response.message = dataException.getMessage();
//            response.data = dataException.getCause();
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return new ResponseExceptionDTO(response,httpStatus);
//    }

    public ResponseExceptionDTO getErrorBusinessException(BusinessException businessException) {
        Response response = new Response();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        response.error = true;
        response.message = businessException.getMessage();
        response.data = businessException.getCause();

        return new ResponseExceptionDTO(response,httpStatus);
    }
}
