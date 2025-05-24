package com.example.appointment_api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:5173") //let react can connected.
public class AppointmentController {
    //用來接收前端（或任何客戶端）發來的 HTTP 請求，處理資料，並回應結果的地方。

    private final AppointmentRepository repository;

    public AppointmentController(AppointmentRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Appointment> getAppointments(){
        return repository.findAll();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment newAppointment){
        return repository.save(newAppointment);
    }
}
