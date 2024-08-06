// src/test/java/com/cts/mis/hospitalappointment/HospitalAppointmentRepositoryTest.java
package repositary;

import com.cts.mis.hospitalappointment.HospitalAppointmentRepository;
import com.cts.mis.hospitalappointment.model.HospitalAppointment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HospitalAppointmentRepositoryTest {
    @Test
    void saveAppointmentSuccessfully() {
        HospitalAppointmentRepository repository = mock(HospitalAppointmentRepository.class);
        HospitalAppointment appointment = new HospitalAppointment(1, "John Doe", "2023-10-06", "Dr. Smith", "Scheduled");
        when(repository.save(appointment)).thenReturn(appointment);
        HospitalAppointment result = repository.save(appointment);
        assertEquals(appointment, result);
    }

    @Test
    void findAppointmentByIdSuccessfully() {
        HospitalAppointmentRepository repository = mock(HospitalAppointmentRepository.class);
        HospitalAppointment appointment = new HospitalAppointment(1, "John Doe", "2023-10-06", "Dr. Smith", "Scheduled");
        when(repository.findById(1)).thenReturn(appointment);
        HospitalAppointment result = repository.findById(1);
        assertEquals(appointment, result);
    }

    @Test
    void findAllAppointmentsReturnsList() {
        HospitalAppointmentRepository repository = mock(HospitalAppointmentRepository.class);
        List<HospitalAppointment> appointments = List.of(
                new HospitalAppointment(1, "John Doe", "2023-10-06", "Dr. Smith", "Scheduled"),
                new HospitalAppointment(2, "Jane Doe", "2023-10-07", "Dr. Brown", "Scheduled")
        );
        when(repository.findAll()).thenReturn(appointments);
        List<HospitalAppointment> result = repository.findAll();
        assertEquals(appointments, result);
    }

    @Test
    void updateAppointmentSuccessfully() {
        HospitalAppointmentRepository repository = mock(HospitalAppointmentRepository.class);
        HospitalAppointment updatedAppointment = new HospitalAppointment(1, "Alice", "2023-10-05", "Dr. White", "Rescheduled");
        when(repository.update(1, updatedAppointment)).thenReturn(updatedAppointment);
        HospitalAppointment result = repository.update(1, updatedAppointment);
        assertEquals(updatedAppointment, result);
    }

    @Test
    void deleteAppointmentByIdSuccessfully() {
        HospitalAppointmentRepository repository = mock(HospitalAppointmentRepository.class);
        when(repository.deleteById(1)).thenReturn(true);
        boolean result = repository.deleteById(1);
        assertTrue(result);
    }

    @Test
    void findAppointmentByIdReturnsNullForNonExistentId() {
        HospitalAppointmentRepository repository = mock(HospitalAppointmentRepository.class);
        when(repository.findById(999)).thenReturn(null);
        HospitalAppointment result = repository.findById(999);
        assertNull(result);
    }

    @Test
    void updateAppointmentThrowsExceptionForNonExistentId() {
        HospitalAppointmentRepository repository = mock(HospitalAppointmentRepository.class);
        HospitalAppointment updatedAppointment = new HospitalAppointment(999, "Alice", "2023-10-05", "Dr. White", "Rescheduled");
        when(repository.update(999, updatedAppointment)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> repository.update(999, updatedAppointment));
    }

    @Test
    void deleteAppointmentByIdReturnsFalseForNonExistentId() {
        HospitalAppointmentRepository repository = mock(HospitalAppointmentRepository.class);
        when(repository.deleteById(999)).thenReturn(false);
        boolean result = repository.deleteById(999);
        assertFalse(result);
    }
}