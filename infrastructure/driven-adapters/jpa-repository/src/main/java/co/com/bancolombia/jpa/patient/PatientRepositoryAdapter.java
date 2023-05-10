package co.com.bancolombia.jpa.patient;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.patient.Patient;
import co.com.bancolombia.model.patient.gateways.PatientRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class PatientRepositoryAdapter extends AdapterOperations<Patient,PatientData,Long,PatientDataRepository> implements
        PatientRepository {
    public PatientRepositoryAdapter(PatientDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d ->mapper.map(d,Patient.class));
    }
    @Override
    public List<Patient> findAll(){
        return  repository.findAll()
                .stream()
                .map(patientData -> toEntity(patientData))
                .collect(Collectors.toList());

    }
    @Override
    public List<Patient> traer(){
        return  repository.traer()
                .stream()
                .map(patientData -> toEntity(patientData))
                .collect(Collectors.toList());

    }
}
