package com.ritesh.Doctor.Suggestion.App.repository;

import com.ritesh.Doctor.Suggestion.App.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepo extends JpaRepository<Patient, Long> {
}
