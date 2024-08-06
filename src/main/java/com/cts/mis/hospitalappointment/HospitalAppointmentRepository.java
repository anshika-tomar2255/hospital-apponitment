package com.cts.mis.hospitalappointment;

import com.cts.mis.hospitalappointment.model.HospitalAppointment;
import java.util.List;

/**
 * Repository interface for managing hospital appointments.
 */
public interface HospitalAppointmentRepository {

    /**
     * Saves a new hospital appointment.
     *
     * @param appointment the appointment to be saved
     * @return the saved appointment
     */
    HospitalAppointment save(HospitalAppointment appointment);

    /**
     * Finds a hospital appointment by its ID.
     *
     * @param id the ID of the appointment to be found
     * @return the found appointment, or null if no appointment with the given ID exists
     */
    HospitalAppointment findById(int id);

    /**
     * Retrieves all hospital appointments.
     *
     * @return a list of all hospital appointments
     */
    List<HospitalAppointment> findAll();

    /**
     * Updates an existing hospital appointment.
     *
     * @param id the ID of the appointment to be updated
     * @param appointment the updated appointment details
     * @return the updated appointment, or null if no appointment with the given ID exists
     */
    HospitalAppointment update(int id, HospitalAppointment appointment);

    /**
     * Deletes a hospital appointment by its ID.
     *
     * @param id the ID of the appointment to be deleted
     * @return true if the appointment was successfully deleted, false otherwise
     */
    boolean deleteById(int id);
}