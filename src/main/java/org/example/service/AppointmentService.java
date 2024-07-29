package org.example.service;

import org.example.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    public AppointmentService() {
        // Adding some hardcoded values
        appointments.add(new Appointment(1, "John Doe", "2023-10-01", "Dr. Smith", "Scheduled"));
        appointments.add(new Appointment(2, "Jane Doe", "2023-10-02", "Dr. Brown", "Scheduled"));
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setId(appointments.size() + 1);
        appointments.add(appointment);
        return appointment;
    }

    public Appointment updateAppointment(int id, Appointment updatedAppointment) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                appointment.setPatientName(updatedAppointment.getPatientName());
                appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
                appointment.setDoctorName(updatedAppointment.getDoctorName());
                appointment.setStatus(updatedAppointment.getStatus());
                return appointment;
            }
        }
        return null;
    }

    public boolean cancelAppointment(int id) {
        return appointments.removeIf(appointment -> appointment.getId() == id);
    }
}
