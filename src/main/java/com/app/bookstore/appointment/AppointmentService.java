package com.app.bookstore.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bookstore.book.Book;
import com.app.bookstore.exemplary.Exemplary;
import com.app.bookstore.exemplary.ExemplaryRepository;
import com.app.bookstore.user.User;
import com.app.bookstore.user.UserRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public Appointment create(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public Appointment findById(Integer id) {
		return appointmentRepository.findById(id).orElseThrow();
	}

	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}

	public Appointment update(Appointment appointmentToUpdate, Integer appointmentId) {
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElseThrow();
		existingAppointment.setUserId(appointmentToUpdate.getUserId());
		existingAppointment.setExemplaryId(appointmentToUpdate.getExemplaryId());
		existingAppointment.setStartDate(appointmentToUpdate.getStartDate());
		existingAppointment.setEndDate(appointmentToUpdate.getEndDate());

		return appointmentRepository.save(existingAppointment);
	}

	public void delete(Integer appointmentId) {
		appointmentRepository.deleteById(appointmentId);
	}

}
