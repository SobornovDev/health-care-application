package ru.sobornov.demospringbootkotlin.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Sobornov Vladimir
 * @since : 18.10.2022
 **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name shouldn't be empty!")
    @Size(min = 2, max = 100, message = "Name must be from 2 to 100 symbols")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname shouldn't be empty!")
    @Size(min = 2, max = 100, message = "Surname must be from 2 to 100 symbols")
    @Column(name = "surname")
    private String surname;

    @Min(value = 1900, message = "Year of birth must be greater than 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Pattern(regexp = "([0-9]{10})", message = "Number must be in format 1234567890")
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    public String getMhi() {
        return mhi;
    }

    @Size(min = 2, max = 100, message = "MHI number must be from 2 to 100 symbols")
    @Column(name = "mhi_number")
    private String mhi;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Enter correct email")
    @Column(name = "email")
    private String email;

}
