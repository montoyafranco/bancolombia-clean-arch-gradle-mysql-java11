package co.com.bancolombia.usecase.getallpatients;

import co.com.bancolombia.model.patient.Patient;
import co.com.bancolombia.model.patient.gateways.PatientRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


public class GetallpatientsUseCase {

    private final PatientRepository patientRepository;

    public GetallpatientsUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public List<Patient> getAllPatients2(){
        return patientRepository.traer();
    }
}
