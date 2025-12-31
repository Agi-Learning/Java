package com.javatechie.controller.doctor;

import com.javatechie.model.doctor.Doctor;
import com.javatechie.service.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;


    @GetMapping("/doctors")
    public Iterable<Doctor> getDoctors(){
        return service.getAllDoctors();
    }
}
