package com.app.bookstore.exemplary;

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

import com.app.bookstore.exemplary.dto.ExemplaryCreateDTO;
import com.app.bookstore.exemplary.dto.ExemplaryGetDTO;
import com.app.bookstore.exemplary.mapper.ExemplaryMapper;

@RestController
@RequestMapping("/exemplaries")
public class ExemplaryController {

	@Autowired
	private ExemplaryService exemplaryService;

	@Autowired
	private ExemplaryMapper exemplaryMapper;

	@PostMapping
	public ResponseEntity<ExemplaryGetDTO> createWithStatus(@RequestBody ExemplaryCreateDTO exemplaryCreateDTO) {
		Exemplary exemplary = exemplaryService.create(exemplaryMapper.exemplaryCreateDTO2Exemplary(exemplaryCreateDTO),
				exemplaryCreateDTO.getBookId());
		return new ResponseEntity<>(exemplaryMapper.exemplary2emplaryGetDTO(exemplary), HttpStatus.CREATED);
	}

//	@PostMapping()
//	public ExemplaryGetDTO create(@RequestBody ExemplaryCreateDTO exemplaryCreateDTO) {
//		Exemplary exemplary = exemplaryMapper.exemplaryCreateDTO2Exemplary(exemplaryCreateDTO);
//		Exemplary createdExemplary = exemplaryService.create(exemplary);
//
//		return exemplaryMapper.exemplary2emplaryGetDTO(createdExemplary);
//	}

	@GetMapping("/{id}")
	public Exemplary findById(@PathVariable Integer id) {
		return exemplaryService.findById(id);
	}

	@GetMapping()
	public List<ExemplaryGetDTO> findAll() {
		return exemplaryService.findAll().stream().map(exemplary -> exemplaryMapper.exemplary2emplaryGetDTO(exemplary))
				.toList();
	}

	@GetMapping("code/{code}")
	public List<ExemplaryGetDTO> findByCode(@PathVariable String code) {
		return exemplaryMapper.listExemplary2listGetDTO(exemplaryService.findByCode(code));

	}

	@PutMapping("/{id}")
	public ExemplaryGetDTO update(@RequestBody ExemplaryCreateDTO exemplaryCreateDTO, @PathVariable Integer id) {
		Exemplary exemplary = exemplaryMapper.exemplaryCreateDTO2Exemplary(exemplaryCreateDTO);
		Exemplary updatedExemplary = exemplaryService.update(exemplary, id);

		return exemplaryMapper.exemplary2emplaryGetDTO(updatedExemplary);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		exemplaryService.delete(id);
	}

}
