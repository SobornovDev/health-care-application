package ru.sobornov.demospringbootkotlin.services

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.sobornov.demospringbootkotlin.models.Patient
import ru.sobornov.demospringbootkotlin.repositories.PatientRepository
import java.util.*

/**
 * @author : Sobornov Vladimir
 * @since : 18.10.2022
 **/

@Service
@Transactional(readOnly = true)
class PatientService (private val patientRepository: PatientRepository, private val kafkaTemplate: KafkaTemplate<String, Patient>) {

    @Transactional
    fun save(patient: Patient)  {
        patientRepository.save(patient)
        kafkaTemplate.send("patients", patient)
    }

    fun findAll(): MutableIterable<Patient> = patientRepository.findAll();

    fun getPatientByMhiNumber(mhiNumber: String): Patient? = patientRepository.findByMhi(mhiNumber)
}