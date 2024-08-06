// src/main/java/com/cts/mis/hospital appointment/controller/HospitalAppointmentController.java
package com.cts.mis.hospitalappointment.controller;

import com.cts.mis.hospitalappointment.model.HospitalAppointment;
import com.cts.mis.hospitalappointment.service.HospitalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing hospital appointments.
 */
@RestController
@RequestMapping("/appointments")
public class HospitalAppointmentController {

    private final HospitalAppointmentService appointmentService;

    /**
     * Constructs a new HospitalAppointmentController with the specified service.
     *
     * @param appointmentService the service to manage hospital appointments
     */
    @Autowired
    public HospitalAppointmentController(HospitalAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /**
     * Retrieves all hospital appointments.
     *
     * @return a list of all hospital appointments
     */
    @GetMapping
    public List<HospitalAppointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    /**
     * Books a new hospital appointment.
     *
     * @param appointment the appointment to be booked
     * @return the booked appointment with a generated ID
     */
    @PostMapping("/book")
    public HospitalAppointment bookAppointment(@RequestBody HospitalAppointment appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    /**
     * Updates an existing hospital appointment.
     *
     * @param updatedAppointment the updated appointment details
     * @return the updated appointment, or null if the appointment ID does not exist
     */
    @PutMapping("/update")
    public HospitalAppointment updateAppointment(@RequestBody HospitalAppointment updatedAppointment) {
        return appointmentService.updateAppointment(updatedAppointment.getId(), updatedAppointment);
    }

    /**
     * Cancels an existing hospital appointment.
     *
     * @param appointment the ID of the appointment to be cancelled
     * @return true if the appointment was successfully cancelled, false otherwise
     */
    @DeleteMapping("/cancel")
    public boolean cancelAppointment(@RequestBody String appointment) {
        return appointmentService.cancelAppointment(appointment);
    }
}