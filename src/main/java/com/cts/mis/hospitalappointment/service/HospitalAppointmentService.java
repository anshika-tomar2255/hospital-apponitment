
// src/main/java/com/cts/mis/hospital appointment/service/HospitalAppointmentService.java
        package com.cts.mis.hospitalappointment.service;

import com.cts.mis.hospitalappointment.model.HospitalAppointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Service class for managing hospital appointments.
 */
@Service
public class HospitalAppointmentService {
    private List<HospitalAppointment> appointments = new ArrayList<>();

    /**
     * Constructs a new HospitalAppointmentService with some hardcoded values.
     */
    public HospitalAppointmentService() {
        appointments.add(new HospitalAppointment(generateAlphanumericId(), "John Doe", "2023-10-01", "Dr. Smith", "Scheduled"));
        appointments.add(new HospitalAppointment(generateAlphanumericId(), "Jane Doe", "2023-10-02", "Dr. Brown", "Scheduled"));
    }

    /**
     * Retrieves all hospital appointments.
     *
     * @return a list of all hospital appointments
     */
    public List<HospitalAppointment> getAllAppointments() {
        return appointments;
    }

    /**
     * Books a new hospital appointment.
     *
     * @param appointment the appointment to be booked
     * @return the booked appointment with a generated ID
     */
    public HospitalAppointment bookAppointment(HospitalAppointment appointment) {
        appointment.setId(generateAlphanumericId());
        appointments.add(appointment);
        return appointment;
    }

    /**
     * Updates an existing hospital appointment.
     *
     * @param id the ID of the appointment to be updated
     * @param updatedAppointment the updated appointment details
     * @return the updated appointment, or null if the appointment ID does not exist
     */
    public HospitalAppointment updateAppointment(String id, HospitalAppointment updatedAppointment) {
        for (HospitalAppointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setPatientName(updatedAppointment.getPatientName());
                appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
                appointment.setDoctorName(updatedAppointment.getDoctorName());
                appointment.setStatus(updatedAppointment.getStatus());
                return appointment;
            }
        }
        return null;
    }

    /**
     * Cancels an existing hospital appointment.
     *
     * @param id the ID of the appointment to be cancelled
     * @return true if the appointment was successfully cancelled, false otherwise
     */
    public boolean cancelAppointment(String id) {
        return appointments.removeIf(appointment -> appointment.getId().equals(id));
    }

    /**
     * Generates a unique alphanumeric ID.
     *
     * @return a unique alphanumeric ID
     */
    private String generateAlphanumericId() {
        return UUID.randomUUID().toString();
    }
}
