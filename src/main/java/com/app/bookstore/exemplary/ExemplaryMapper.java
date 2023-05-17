package com.app.bookstore.exemplary;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ExemplaryMapper {

	public Exemplary exemplaryCreateDTO2Exemplary(ExemplaryCreateDTO exemplaryCreateDTO) {
		Exemplary exemplary = new Exemplary();
		exemplary.setCode(exemplaryCreateDTO.getCode());
		exemplary.setDate(exemplaryCreateDTO.getDate());
		exemplary.setPageNumbers(exemplaryCreateDTO.getPageNumbers());

		return exemplary;
	}

	public ExemplaryGetDTO exemplary2emplaryGetDTO(Exemplary exemplary) {
		ExemplaryGetDTO exemplaryGetDTO = new ExemplaryGetDTO();
		exemplaryGetDTO.setId(exemplary.getId());
		exemplaryGetDTO.setCode(exemplary.getCode());
		exemplaryGetDTO.setDate(exemplary.getDate());
		exemplaryGetDTO.setPageNumbers(exemplary.getPageNumbers());

		return exemplaryGetDTO;

	}

	public List<ExemplaryGetDTO> listExemplary2listGetDTO(List<Exemplary> exemplaries) {
		return exemplaries.stream().map(exemplary -> exemplary2emplaryGetDTO(exemplary)).toList();
	}

}
