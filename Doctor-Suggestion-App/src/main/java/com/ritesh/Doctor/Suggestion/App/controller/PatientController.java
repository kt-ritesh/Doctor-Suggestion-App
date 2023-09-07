package com.ritesh.Doctor.Suggestion.App.controller;

import com.ritesh.Doctor.Suggestion.App.model.Patient;
import com.ritesh.Doctor.Suggestion.App.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("add/patient")
    public String addPatient(@Valid @RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @DeleteMapping("delete/patient")
    public String deletePatient(@RequestParam Long id){
        return patientService.deletePatient(id);
    }

    @GetMapping("doctor/suggestion")
    public String doctorSuggestion(@RequestParam Long patient_id){
        return patientService.doctorSuggestion(patient_id);
    }

    @PutMapping("update/patient/symptom")
    public String updatePatientSymptom(@RequestParam Long patient_id, @RequestParam String symptom){
        return patientService.updatePatientSymptom(patient_id, symptom);
    }

    @PutMapping("update/patient/city")
    public String updatePatientCity(@RequestParam Long patient_id, @RequestParam String city){
        return patientService.updatePatientCity(patient_id, city);
    }
}
