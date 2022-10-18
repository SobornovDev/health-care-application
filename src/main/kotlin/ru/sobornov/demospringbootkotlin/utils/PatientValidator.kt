package ru.sobornov.demospringbootkotlin.utils

import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import ru.sobornov.demospringbootkotlin.models.Patient
import ru.sobornov.demospringbootkotlin.services.PatientService

/**
 * @author : Sobornov Vladimir
 * @since : 18.10.2022
 **/

@Component
class PatientValidator (private val patientService: PatientService): Validator {


    override fun supports(clazz: Class<*>): Boolean = Patient::class == clazz


    override fun validate(target: Any, errors: Errors) {
        val patient: Patient = target as Patient
        if (patientService.getPatientByMhiNumber(patient.mhi) != null)
            errors.rejectValue("mhi", "", "Patient with this policy number already exists");

    }


}