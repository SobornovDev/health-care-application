package ru.sobornov.demospringbootkotlin.controllers

import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.sobornov.demospringbootkotlin.models.Patient
import ru.sobornov.demospringbootkotlin.services.PatientService
import ru.sobornov.demospringbootkotlin.utils.PatientValidator


/**
 * @author : Sobornov Vladimir
 * @since : 18.10.2022
 **/
@Controller
@RequestMapping("/patients")
class PatientController (private val patientService: PatientService, private val patientValidator: PatientValidator){


    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("patients", patientService.findAll())
        return "patients/index"
    }

    @GetMapping("/new")
    fun newPatient(@ModelAttribute("patient") patient: Patient): String = "patients/new"

    @PostMapping
    fun create(@ModelAttribute("patient") @Valid patient: Patient, bindingResult: BindingResult): String {

        patientValidator.validate(patient, bindingResult)
        if (bindingResult.hasErrors())
            return "patients/new"

        patientService.save(patient)
        return "redirect:/patients"
    }

}