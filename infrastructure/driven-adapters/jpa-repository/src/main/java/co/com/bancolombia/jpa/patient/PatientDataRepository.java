package co.com.bancolombia.jpa.patient;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface PatientDataRepository extends JpaRepository<PatientData,Long> {
    @Query(value = "SELECT * FROM patient", nativeQuery = true)
    List<PatientData> findAll();

    @Query("select p from PatientData p")
    List<PatientData> traer();



}
