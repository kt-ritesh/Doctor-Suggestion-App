package com.ritesh.Doctor.Suggestion.App.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=3, message = "In the name there should be at least 3 character.")
    private String Name;

    @Email(message = "Enter a valid Email.")
    private String Email;

    @Size(min = 10, max = 13)
    private String mobNo;

    @Size(max = 20)
    private String city;

    private String speciality;
}
