package co.com.bancolombia.api;
import co.com.bancolombia.model.patient.Patient;
import co.com.bancolombia.usecase.getallpatients.GetallpatientsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
//    private final MyUseCase useCase;

    private final GetallpatientsUseCase getallpatientsUseCase;


    @GetMapping(path = "/getAllPatients")
    public ResponseEntity getAllPatients() {

        try {
            List<Patient> patients = getallpatientsUseCase.getAllPatients();
            return ResponseEntity.ok(patients);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Alto error pibe");
        }
    }
}
