package ru.sobornov.demospringbootkotlin.services;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sobornov.demospringbootkotlin.models.Doctor;
import ru.sobornov.demospringbootkotlin.models.Patient;
import ru.sobornov.demospringbootkotlin.repositories.DoctorRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author : Sobornov Vladimir
 * @since : 22.10.2022
 **/
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Transactional
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Iterable<Doctor> findAll() {
        return doctorRepository.findAll();
    }
    public Optional<Doctor> findOne(int id) {
        return doctorRepository.findById(id);
    }

    public List<Patient> getPatientsById(int id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            Hibernate.initialize(doctor.get().getPatients());
            return doctor.get().getPatients();
        } else {
            return Collections.emptyList();
        }
    }
}
