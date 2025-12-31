package com.javatechie.service.doctor;


import com.javatechie.dao.doctor.DoctorRepository;
import com.javatechie.model.doctor.Doctor;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatechie.mailservice.EmailService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private EmailService service;

    @PostConstruct
    public void initDoctors(){
        Doctor doctor1 = new Doctor();
        doctor1.setName("John");
        doctor1.setSpeciality("Cardiac");

        Doctor doctor2 = new Doctor();
        doctor2.setName("peter");
        doctor2.setSpeciality("eye");

        repository.saveAll(List.of(doctor1, doctor2));
    }

    public List<Doctor> getAllDoctors(){
        service.sendEMail();
        return repository.findAll();
    }
}
