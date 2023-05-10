package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.PatientResponseDTO;
import co.com.bancolombia.api.utility.Response;
import co.com.bancolombia.api.utility.ResponseExceptionDTO;
import co.com.bancolombia.api.utility.apiresthelper.ApiErrorHelper;
import co.com.bancolombia.model.patient.Patient;
import co.com.bancolombia.usecase.getallpatients.GetallpatientsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor

public class ApiRest {

    //    private final MyUseCase useCase;


    @Autowired
    private ApiErrorHelper apiErrorHelper;
    private Response response = new Response();


    private final GetallpatientsUseCase getallpatientsUseCase;



    @GetMapping(path = "/getAllPatients")
    public ResponseEntity<Response> getPatientList() {
        response.restart();
        try {
            List<Patient> patients = getallpatientsUseCase
                    .getAllPatients();

            response.data = patients
                    .stream()
                    .map(patient ->
                            new PatientResponseDTO(patient.getId(), patient.getName()))
                    .collect
                            (Collectors.toList());
            response.message = "Exitosamente se ha traido la lista de usuarios";
            HttpStatus httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            ResponseExceptionDTO responseExceptionDTO = apiErrorHelper.getErrorMessageInternal(exception);
            response = responseExceptionDTO.getResponse();
            HttpStatus httpStatus = responseExceptionDTO.getHttpStatus();
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
