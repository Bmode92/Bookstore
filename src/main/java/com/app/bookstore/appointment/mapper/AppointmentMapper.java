package com.app.bookstore.appointment.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.bookstore.appointment.Appointment;
import com.app.bookstore.appointment.dto.AppointmentCreateDTO;
import com.app.bookstore.appointment.dto.AppointmentGetDTO;

@Component
public class AppointmentMapper {

	public Appointment appointmentCreateDTO2appointment(AppointmentCreateDTO appointmentCreateDTO) {
		Appointment appointment = new Appointment();
		appointment.setUserId(appointmentCreateDTO.getUserId());
		appointment.setExemplaryId(appointmentCreateDTO.getExemplaryId());
		appointment.setStartDate(appointmentCreateDTO.getStartDate());
		appointment.setEndDate(appointmentCreateDTO.getEndDate());

		return appointment;
	}

	public AppointmentGetDTO appointment2appointmentGetDTO(Appointment appointment) {
		AppointmentGetDTO appointmentGetDTO = new AppointmentGetDTO();
		appointmentGetDTO.setId(appointment.getId());
		appointmentGetDTO.setUserId(appointment.getUserId());
		appointmentGetDTO.setExemplaryId(appointment.getExemplaryId());
		appointmentGetDTO.setStartDate(appointment.getStartDate());
		appointmentGetDTO.setEndDate(appointment.getEndDate());

		return appointmentGetDTO;
	}

	public List<AppointmentGetDTO> listAppointment2listGetDTO(List<Appointment> appointments) {
		return appointments.stream().map(appointment -> appointment2appointmentGetDTO(appointment)).toList();
	}

}
