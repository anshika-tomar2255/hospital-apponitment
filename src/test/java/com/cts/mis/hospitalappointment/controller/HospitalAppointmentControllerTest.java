// src/test/java/com/cts/mis/hospital appointment/controller/HospitalAppointmentControllerTest.java
package com.cts.mis.hospitalappointment.controller;

import com.cts.mis.hospitalappointment.model.HospitalAppointment;
import com.cts.mis.hospitalappointment.service.HospitalAppointmentService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HospitalAppointmentControllerTest {
    @Test
    void getAllAppointmentsReturnsListOfAppointments() {
        HospitalAppointmentService appointmentService = mock(HospitalAppointmentService.class);
        HospitalAppointmentController controller = new HospitalAppointmentController(appointmentService);
        List<HospitalAppointment> appointments = List.of(
                new HospitalAppointment("1", "John Doe", "2023-10-06", "Dr. Smith", "Scheduled"),
                new HospitalAppointment("2", "Jane Doe", "2023-10-07", "Dr. Brown", "Scheduled")
        );
        when(appointmentService.getAllAppointments()).thenReturn(appointments);
        List<HospitalAppointment> result = controller.getAllAppointments();
        assertEquals(appointments, result);
    }

    @Test
    void bookAppointmentEndpointBooksNewAppointment() {
        HospitalAppointmentService appointmentService = mock(HospitalAppointmentService.class);
        HospitalAppointmentController controller = new HospitalAppointmentController(appointmentService);
        HospitalAppointment newAppointment = new HospitalAppointment("1", "John Doe", "2023-10-06", "Dr. Smith", "Scheduled");
        when(appointmentService.bookAppointment(newAppointment)).thenReturn(newAppointment);
        HospitalAppointment result = controller.bookAppointment(newAppointment);
        assertEquals(newAppointment, result);
    }

    @Test
    void updateAppointmentEndpointUpdatesExistingAppointment() {
        HospitalAppointmentService appointmentService = mock(HospitalAppointmentService.class);
        HospitalAppointmentController controller = new HospitalAppointmentController(appointmentService);
        HospitalAppointment updatedAppointment = new HospitalAppointment("1", "Alice", "2023-10-05", "Dr. White", "Rescheduled");
        when(appointmentService.updateAppointment("1", updatedAppointment)).thenReturn(updatedAppointment);
        HospitalAppointment result = controller.updateAppointment(updatedAppointment);
        assertEquals(updatedAppointment, result);
    }

    @Test
    void cancelAppointmentEndpointCancelsExistingAppointment() {
        HospitalAppointmentService appointmentService = mock(HospitalAppointmentService.class);
        HospitalAppointmentController controller = new HospitalAppointmentController(appointmentService);
        when(appointmentService.cancelAppointment("1")).thenReturn(true);
        boolean result = controller.cancelAppointment("1");
        assertTrue(result);
    }

    @Test
    void updateAppointmentEndpointWithInvalidDataThrowsException() {
        HospitalAppointmentService appointmentService = mock(HospitalAppointmentService.class);
        HospitalAppointmentController controller = new HospitalAppointmentController(appointmentService);
        HospitalAppointment invalidAppointment = new HospitalAppointment("1", "", "", "", "");
        when(appointmentService.updateAppointment("1", invalidAppointment)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> controller.updateAppointment(invalidAppointment));
    }

    @Test
    void cancelAppointmentEndpointWithInvalidDataThrowsException() {
        HospitalAppointmentService appointmentService = mock(HospitalAppointmentService.class);
        HospitalAppointmentController controller = new HospitalAppointmentController(appointmentService);
        when(appointmentService.cancelAppointment("")).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> controller.cancelAppointment(""));
    }

    @Test
    void cancelAppointmentEndpointWithNullIdThrowsException() {
        HospitalAppointmentService appointmentService = mock(HospitalAppointmentService.class);
        HospitalAppointmentController controller = new HospitalAppointmentController(appointmentService);
        when(appointmentService.cancelAppointment(null)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> controller.cancelAppointment(null));
    }

    @Test
    void updateAppointmentEndpointWithNonExistentIdThrowsException() {
        HospitalAppointmentService appointmentService = mock(HospitalAppointmentService.class);
        HospitalAppointmentController controller = new HospitalAppointmentController(appointmentService);
        HospitalAppointment nonExistentAppointment = new HospitalAppointment("999", "Alice", "2023-10-05", "Dr. White", "Rescheduled");
        when(appointmentService.updateAppointment("999", nonExistentAppointment)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> controller.updateAppointment(nonExistentAppointment));
    }
}