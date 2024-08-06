// src/main/java/com/cts/mis/hospitalappointment/model/HospitalAppointment.java
package com.cts.mis.hospitalappointment.model;

/**
 * Represents a hospital appointment.
 */
public class HospitalAppointment {
    private String id;
    private String patientName;
    private String appointmentDate;
    private String doctorName;
    private String status;

    /**
     * Constructs a new HospitalAppointment with the specified details.
     *
     * @param id the unique identifier of the appointment
     * @param patientName the name of the patient
     * @param appointmentDate the date of the appointment
     * @param doctorName the name of the doctor
     * @param status the status of the appointment
     */
    public HospitalAppointment(String id, String patientName, String appointmentDate, String doctorName, String status) {
        this.id = id;
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.status = status;
    }

    /**
     * Default constructor.
     */
    public HospitalAppointment() {
    }

    /**
     * Constructs a new HospitalAppointment with the specified details.
     *
     * @param patientName the name of the patient
     * @param appointmentDate the date of the appointment
     * @param doctorName the name of the doctor
     * @param status the status of the appointment
     */
    public HospitalAppointment(String patientName, String appointmentDate, String doctorName, String status) {
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.status = status;
    }

    /**
     * Constructs a new HospitalAppointment with the specified details.
     *
     * @param id the unique identifier of the appointment
     * @param patientName the name of the patient
     * @param appointmentDate the date of the appointment
     * @param doctorName the name of the doctor
     * @param status the status of the appointment
     */
    public HospitalAppointment(int id, String patientName, String appointmentDate, String doctorName, String status) {
        this.id = String.valueOf(id);
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.status = status;
    }

    /**
     * Gets the unique identifier of the appointment.
     *
     * @return the unique identifier of the appointment
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the appointment.
     *
     * @param id the unique identifier of the appointment
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of the patient.
     *
     * @return the name of the patient
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Sets the name of the patient.
     *
     * @param patientName the name of the patient
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * Gets the date of the appointment.
     *
     * @return the date of the appointment
     */
    public String getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Sets the date of the appointment.
     *
     * @param appointmentDate the date of the appointment
     */
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * Gets the name of the doctor.
     *
     * @return the name of the doctor
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * Sets the name of the doctor.
     *
     * @param doctorName the name of the doctor
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * Gets the status of the appointment.
     *
     * @return the status of the appointment
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the appointment.
     *
     * @param status the status of the appointment
     */
    public void setStatus(String status) {
        this.status = status;
    }
}