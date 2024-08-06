// src/test/java/com/cts/mis/hospital appointment/service/HospitalAppointmentServiceTest.java
package com.cts.mis.hospitalappointment.service;

import com.cts.mis.hospitalappointment.model.HospitalAppointment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HospitalAppointmentServiceTest {

    @Test
    void bookAppointmentGeneratesUniqueIds() {
        HospitalAppointment firstAppointment = new HospitalAppointment("Alice", "2023-10-03", "Dr. White", "Scheduled");
        HospitalAppointment secondAppointment = new HospitalAppointment("Bob", "2023-10-04", "Dr. Black", "Scheduled");
        HospitalAppointmentService appointmentService = new HospitalAppointmentService();
        HospitalAppointment bookedFirst = appointmentService.bookAppointment(firstAppointment);
        HospitalAppointment bookedSecond = appointmentService.bookAppointment(secondAppointment);
        assertNotEquals(bookedFirst.getId(), bookedSecond.getId());
    }

    @Test
    void updateAppointmentDoesNotChangeId() {
        HospitalAppointmentService appointmentService = new HospitalAppointmentService();
        HospitalAppointment originalAppointment = appointmentService.getAllAppointments().get(0);
        String originalId = originalAppointment.getId();
        HospitalAppointment updatedAppointment = new HospitalAppointment("John Doe", "2023-10-05", "Dr. Smith", "Rescheduled");
        HospitalAppointment result = appointmentService.updateAppointment(originalId, updatedAppointment);
        assertEquals(originalId, result.getId());
    }

    @Test
    void bookAppointmentWithNullValues() {
        HospitalAppointment newAppointment = new HospitalAppointment(null, null, null, null);
        HospitalAppointmentService appointmentService = new HospitalAppointmentService();
        HospitalAppointment bookedAppointment = appointmentService.bookAppointment(newAppointment);
        assertNotNull(bookedAppointment.getId());
        assertNull(bookedAppointment.getPatientName());
        assertNull(bookedAppointment.getAppointmentDate());
        assertNull(bookedAppointment.getDoctorName());
        assertNull(bookedAppointment.getStatus());
    }

    @Test
    void updateAppointmentWithNullValues() {
        HospitalAppointmentService appointmentService = new HospitalAppointmentService();
        HospitalAppointment originalAppointment = appointmentService.getAllAppointments().get(0);
        HospitalAppointment updatedAppointment = new HospitalAppointment(null, null, null, null);
        HospitalAppointment result = appointmentService.updateAppointment(originalAppointment.getId(), updatedAppointment);
        assertNotNull(result);
        assertNull(result.getPatientName());
        assertNull(result.getAppointmentDate());
        assertNull(result.getDoctorName());
        assertNull(result.getStatus());
    }

    @Test
    void getAllAppointmentsReturnsEmptyListWhenNoAppointments() {
        HospitalAppointmentService emptyService = new HospitalAppointmentService();
        emptyService.getAllAppointments().clear();
        List<HospitalAppointment> appointments = emptyService.getAllAppointments();
        assertTrue(appointments.isEmpty());
    }

    @Test
    void cancelAppointmentReturnsFalseForAlreadyCancelledAppointment() {
        HospitalAppointmentService appointmentService = new HospitalAppointmentService();
        String id = appointmentService.getAllAppointments().get(0).getId();
        appointmentService.cancelAppointment(id);
        boolean result = appointmentService.cancelAppointment(id);
        assertFalse(result);
    }

    @Test
    void bookAppointmentIncreasesAppointmentListSize() {
        HospitalAppointmentService appointmentService = new HospitalAppointmentService();
        int initialSize = appointmentService.getAllAppointments().size();
        HospitalAppointment newAppointment = new HospitalAppointment("Charlie", "2023-10-06", "Dr. Green", "Scheduled");
        appointmentService.bookAppointment(newAppointment);
        assertEquals(initialSize + 1, appointmentService.getAllAppointments().size());
    }

    @Test
    void cancelAppointmentDecreasesAppointmentListSize() {
        HospitalAppointmentService appointmentService = new HospitalAppointmentService();
        int initialSize = appointmentService.getAllAppointments().size();
        String id = appointmentService.getAllAppointments().get(0).getId();
        appointmentService.cancelAppointment(id);
        assertEquals(initialSize - 1, appointmentService.getAllAppointments().size());
    }

    @Test
    void updateAppointmentWithNonExistingIdReturnsNull() {
        HospitalAppointment updatedAppointment = new HospitalAppointment("John Doe", "2023-10-05", "Dr. Smith", "Rescheduled");
        HospitalAppointmentService appointmentService = new HospitalAppointmentService();
        HospitalAppointment result = appointmentService.updateAppointment("999", updatedAppointment);
        assertNull(result);
    }

    @Test
    void cancelAppointmentWithNonExistingIdReturnsFalse() {
        HospitalAppointmentService appointmentService = new HospitalAppointmentService();
        boolean result = appointmentService.cancelAppointment("999");
        assertFalse(result);
    }
}