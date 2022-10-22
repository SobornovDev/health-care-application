package ru.sobornov.demospringbootkotlin.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author : Sobornov Vladimir
 * @since : 22.10.2022
 **/

@Entity
@Data
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "speciality")
    private String speciality;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;
}
