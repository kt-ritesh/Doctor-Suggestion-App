package com.ritesh.Doctor.Suggestion.App.repository;

import com.ritesh.Doctor.Suggestion.App.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor, Long> {
    List<Doctor> findAllBySpeciality(String orthopedic);
    List<Doctor> findAllBySpecialityAndCity(String orthopedic, String city);
}
