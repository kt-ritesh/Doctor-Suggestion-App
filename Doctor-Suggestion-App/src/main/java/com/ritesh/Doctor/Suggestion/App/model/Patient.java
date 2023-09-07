package com.ritesh.Doctor.Suggestion.App.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=3, message = "In the name there should be at least 3 character.")
    private String Name;

    @Email(message = "Enter a valid Email.")
    @Column(unique = true)
    private String Email;

    @Size(min = 10, max = 13)
    private String mobNo;

    @NotEmpty
    @Size(max = 20)
    private String city;

    private String symptom;
}
