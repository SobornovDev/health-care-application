package ru.sobornov.demospringbootkotlin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sobornov.demospringbootkotlin.models.Doctor;
import ru.sobornov.demospringbootkotlin.services.DoctorService;

/**
 * @author : Sobornov Vladimir
 * @since : 22.10.2022
 **/
@Controller
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("doctors", doctorService.findAll());
        return "doctors/index";
    }

    @GetMapping("/new")
    public String newDoctor(@ModelAttribute("doctor") Doctor doctor) {
        return "doctors/new";
    }

    @PostMapping
    public String create(@ModelAttribute("doctor")Doctor doctor) {
        doctorService.save(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/{id}")
    public String showPatients(@PathVariable("id") int id, Model model) {
        model.addAttribute("doctor", doctorService.findOne(id).get());
        model.addAttribute("patients", doctorService.getPatientsById(id));

        return "doctors/show";
    }



}
