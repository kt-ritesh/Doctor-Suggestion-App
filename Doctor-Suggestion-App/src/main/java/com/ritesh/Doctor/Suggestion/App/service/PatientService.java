package com.ritesh.Doctor.Suggestion.App.service;

import com.ritesh.Doctor.Suggestion.App.model.Doctor;
import com.ritesh.Doctor.Suggestion.App.model.Patient;
import com.ritesh.Doctor.Suggestion.App.repository.IDoctorRepo;
import com.ritesh.Doctor.Suggestion.App.repository.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    IPatientRepo iPatientRepo;

    @Autowired
    IDoctorRepo iDoctorRepo;

    public String addPatient(Patient patient) {
            iPatientRepo.save(patient);
            return "A patient added!";
    }

    public String deletePatient(Long id) {
        Optional<Patient> patient = iPatientRepo.findById(id);
        if(patient.isEmpty()) return "Please enter a valid Patient id.";
        else {
            iPatientRepo.deleteById(id);
            return "A patient delete..";
        }
    }


    public String doctorSuggestion(Long patient_id) {
        Optional<Patient> patient = iPatientRepo.findById(patient_id);
        if(patient.isEmpty()) return  "Please enter a valid Patient id..";

        if(ValidPatient(patient.get()).equals("All ok")){
            return getDoctorSuggestion(patient.get());
        }
        else {
            return ValidPatient(patient.get());
        }
    }

    private String getDoctorSuggestion(Patient patient) {
        if(patient.getSymptom().equals("Arthritis") || patient.getSymptom().equals("Back Pain") ||patient.getSymptom().equals("Tissue injuries")){
            List<Doctor> doctors = iDoctorRepo.findAllBySpecialityAndCity("Orthopedic", patient.getCity());
            if(doctors.isEmpty()) return "Currently doctors are not available.";
            return "You should contact with this doctor:"+doctors.toString();
        }
        if(patient.getSymptom().equals("Dysmenorrhea")){
            List<Doctor> doctors = iDoctorRepo.findAllBySpecialityAndCity("Gynecology", patient.getCity());
            if(doctors.isEmpty()) return "Currently doctors are not available.";
            return "You should contact with this doctors:"+doctors.toString();
        }
        if(patient.getSymptom().equals("Skin infection") || patient.getSymptom().equals("skin burn")){
            List<Doctor> doctors = iDoctorRepo.findAllBySpecialityAndCity("Dermatology", patient.getCity());
            if(doctors.isEmpty()) return "Currently doctors are not available.";
            return "You should contact with this doctor:"+doctors.toString();
        }
        if(patient.getSymptom().equals("Ear Pain")){
            List<Doctor> doctors = iDoctorRepo.findAllBySpecialityAndCity("ENT", patient.getCity());
            if(doctors.isEmpty()) return "Currently doctors are not available.";
            return "You should contact with this doctor:"+doctors.toString();
        }
        return "Currently doctors are not available.";
    }

    public static String ValidPatient(Patient patient){
        if(!(patient.getCity().equals("Noida") || patient.getCity().equals("Delhi") || patient.getCity().equals("Faridabad"))){
            return "We are still waiting to expend to your location.";
        }
        if(!(patient.getSymptom().equals("Arthritis") || patient.getSymptom().equals("Back Pain") || patient.getSymptom().equals("Tissue injuries") ||patient.getSymptom().equals("Dysmenorrhea")
                || patient.getSymptom().equals("Skin infection") || patient.getSymptom().equals("skin burn") || patient.getSymptom().equals("Ear Pain"))){
            return "There isn’t any doctor present at your location for your symptom.";
        }
        return "All ok";
    }


    public String updatePatientSymptom(Long patient_id, String symptom) {
        Patient patient = iPatientRepo.findById(patient_id).orElse(null);
        if(patient==null) return "Patient does not exists..";

        patient.setSymptom(symptom);

        iPatientRepo.save(patient);
        return "Patient symptom updated..";
    }

    public String updatePatientCity(Long patient_id, String city) {
        Patient patient = iPatientRepo.findById(patient_id).orElse(null);
        if(patient==null) return "Patient does not exists..";

        patient.setCity(city);

        iPatientRepo.save(patient);
        return "Patient city updated..";
    }
}
