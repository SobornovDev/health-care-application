package ru.sobornov.demospringbootkotlin.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.sobornov.demospringbootkotlin.models.Patient


/**
 * @author : Sobornov Vladimir
 * @since : 18.10.2022
 **/
@Repository
interface PatientRepository: CrudRepository<Patient, Integer> {
    fun findByMhi(mhi_number: String): Patient?
}