package ru.sobornov.demospringbootkotlin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sobornov.demospringbootkotlin.models.Doctor;

/**
 * @author : Sobornov Vladimir
 * @since : 22.10.2022
 **/
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
