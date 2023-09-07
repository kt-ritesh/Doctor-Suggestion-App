package com.ritesh.Doctor.Suggestion.App.controller;

import com.ritesh.Doctor.Suggestion.App.model.Doctor;
import com.ritesh.Doctor.Suggestion.App.service.DoctorService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("add/doctor")
    public String addDoctor(@Valid @RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("delete/doctor/{id}")
    public String removeDoctor(@PathVariable Long id){
        return doctorService.removeDoctor(id);
    }

    @GetMapping("doctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
}
