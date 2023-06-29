package com.app.bookstore.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.appointment.dto.AppointmentCreateDTO;
import com.app.bookstore.appointment.dto.AppointmentGetDTO;
import com.app.bookstore.appointment.mapper.AppointmentMapper;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;

	@PostMapping
	public ResponseEntity<AppointmentGetDTO> createWithStatus(@RequestBody AppointmentCreateDTO appointmentCreateDTO) {
		Appointment appointment = appointmentService
				.create(appointmentMapper.appointmentCreateDTO2appointment(appointmentCreateDTO));
		return new ResponseEntity<>(appointmentMapper.appointment2appointmentGetDTO(appointment), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public AppointmentGetDTO findById(@PathVariable Integer id) {
		Appointment appointment = appointmentService.findById(id);
		return appointmentMapper.appointment2appointmentGetDTO(appointment);
	}

	@GetMapping()
	public List<AppointmentGetDTO> findAll() {
		return appointmentService.findAll().stream()
				.map(appointment -> appointmentMapper.appointment2appointmentGetDTO(appointment)).toList();
	}

	@PutMapping("/{id}")
	public AppointmentGetDTO update(@RequestBody AppointmentCreateDTO appointmentCreateDTO, @PathVariable Integer id) {
		Appointment appointment = appointmentMapper.appointmentCreateDTO2appointment(appointmentCreateDTO);
		Appointment updatedAppointment = appointmentService.update(appointment, id);

		return appointmentMapper.appointment2appointmentGetDTO(updatedAppointment);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		appointmentService.delete(id);
	}

}
