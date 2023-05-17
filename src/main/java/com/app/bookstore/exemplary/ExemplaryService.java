package com.app.bookstore.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExemplaryService {

	@Autowired
	private ExemplaryRepository exemplaryRepository;

	public Exemplary create(Exemplary exemplary) {
		return exemplaryRepository.save(exemplary);
	}

	public Exemplary findById(Integer id) {
		return exemplaryRepository.findById(id).orElseThrow();
	}

	public List<Exemplary> findByCode(String code) {
		return exemplaryRepository.findByCode(code);
	}

	public List<Exemplary> findAll() {
		return exemplaryRepository.findAll();
	}

	public Exemplary update(Exemplary exemplaryToUpdate, Integer exemplaryId) {
		Exemplary existingExemplary = exemplaryRepository.findById(exemplaryId).orElseThrow();
		existingExemplary.setCode(exemplaryToUpdate.getCode());
		existingExemplary.setDate(exemplaryToUpdate.getDate());
		existingExemplary.setPageNumbers(exemplaryToUpdate.getPageNumbers());

		return exemplaryRepository.save(existingExemplary);
	}

	public void delete(Integer exemplaryId) {
		exemplaryRepository.deleteById(exemplaryId);
	}
}
