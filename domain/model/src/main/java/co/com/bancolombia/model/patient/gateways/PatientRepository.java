package co.com.bancolombia.model.patient.gateways;

import co.com.bancolombia.model.patient.Patient;

import java.util.ArrayList;
import java.util.List;

public interface PatientRepository {
    List<Patient> findAll();

    List<Patient> traer();

    Patient save( Patient patient);
}
