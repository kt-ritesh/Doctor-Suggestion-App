package com.ritesh.Doctor.Suggestion.App.service;

import com.ritesh.Doctor.Suggestion.App.model.Doctor;
import com.ritesh.Doctor.Suggestion.App.repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    IDoctorRepo iDoctorRepo;

    public String addDoctor(Doctor doctor) {
        if(isValid(doctor).isEmpty()){
            iDoctorRepo.save(doctor);
            return "A doctor added successfully.";
        }
        else {
            return isValid(doctor).toString();
        }
    }

    public static Map<String , String > isValid(Doctor doctor){
        Map<String ,String > rv = new HashMap<>();
        if(!(doctor.getCity().equals("Noida") || doctor.getCity().equals("Delhi") || doctor.getCity().equals("Faridabad"))){
            rv.put(doctor.getCity(), "Please Enter city in Noida, Delhi and Faridabad");
        }
        if(!(doctor.getSpeciality().equals("Orthopedic") || doctor.getSpeciality().equals("Gynecology") || doctor.getSpeciality().equals("Dermatology") || doctor.getSpeciality().equals("ENT"))){
            rv.put(doctor.getSpeciality(), "Please Enter speciality in Orthopedic, Gynecology, Dermatology and ENT");
        }
        return rv;
    }
    public String removeDoctor(Long id) {
        Optional<Doctor> doctor = iDoctorRepo.findById(id);
        if(doctor.isEmpty()){
            return "Please enter a valid email!!";
        }else {
            iDoctorRepo.deleteById(id);
            return "A doctor deleted!";
        }

    }

    public List<Doctor> getAllDoctors() {
        return iDoctorRepo.findAll();
    }
}
