package ru.sobornov.demospringbootkotlin.repositories

import org.springframework.data.repository.CrudRepository
import ru.sobornov.demospringbootkotlin.models.Patient


/**
 * @author : Sobornov Vladimir
 * @since : 18.10.2022
 **/
interface PatientRepository: CrudRepository<Patient, Integer> {
    fun findByMhi(mhi_number: String): Patient?
}