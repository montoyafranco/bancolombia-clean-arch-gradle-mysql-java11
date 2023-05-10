package co.com.bancolombia.usecase.createpatient;

import co.com.bancolombia.model.patient.Patient;
import co.com.bancolombia.model.patient.gateways.PatientRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CreatePatientUseCase {
    private final PatientRepository patientRepository;



    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }


}
