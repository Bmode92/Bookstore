package com.app.bookstore.car;

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

import com.app.bookstore.book.Book;
import com.app.bookstore.book.BookService;
import com.app.bookstore.book.dto.BookCreateDTO;
import com.app.bookstore.book.dto.BookGetDTO;
import com.app.bookstore.book.dto.BookWithExemplariesDTO;
import com.app.bookstore.book.mapper.BookMapper;
import com.app.bookstore.car.dto.CarCreateDTO;
import com.app.bookstore.car.dto.CarGetDTO;
import com.app.bookstore.car.mapper.CarMapper;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@Autowired
	private CarMapper carMapper;

	@PostMapping
	public ResponseEntity<CarGetDTO> create(@RequestBody CarCreateDTO carCreateDTO) {
		Car car = carService.create(carMapper.carCreateDTO2Car(carCreateDTO));
		return new ResponseEntity<>(carMapper.car2carGetDTO(car), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public CarGetDTO findById(@PathVariable Integer id) {
		Car car = carService.findById(id);
		return carMapper.car2carGetDTO(car);
	}

	@GetMapping("/list")
	public List<CarGetDTO> findAll() {
		return carService.findAll().stream().map(car -> carMapper.car2carGetDTO(car)).toList();
	}

	@PutMapping("/{id}")
	public CarGetDTO update(@RequestBody CarCreateDTO carCreateDTO, @PathVariable Integer id) {
		Car car = carMapper.carCreateDTO2Car(carCreateDTO);
		Car updatedCar = carService.update(car, id);

		return carMapper.car2carGetDTO(updatedCar);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		carService.delete(id);
	}

}
