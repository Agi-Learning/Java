package com.javatechie.dao.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javatechie.model.doctor.Doctor;
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
