package com.app.bookstore.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bookstore.person.Person;
import com.app.bookstore.person.PersonRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private PersonRepository personRepository;

	public Car create(Car car) {
		return carRepository.save(car);
	}

	public Car createWithPersonId(Car car, Integer personId) {
		Person person = personRepository.findById(personId).orElseThrow();
		person.addCar(car);

		return carRepository.saveAndFlush(car);
	}

	public Car findById(Integer id) {
		return carRepository.findById(id).orElseThrow();
	}

	public List<Car> findAll() {
		return carRepository.findAll();
	}

	public Car update(Car carToUpdate, Integer carId) {
		Car existingCar = carRepository.findById(carId).orElseThrow();
		existingCar.setMarca(carToUpdate.getMarca());
		existingCar.setModel(carToUpdate.getModel());
		existingCar.setDataFabricatie(carToUpdate.getDataFabricatie());
		existingCar.setCaiPutere(carToUpdate.getCaiPutere());

		return carRepository.save(existingCar);
	}

	public void delete(Integer carId) {
		carRepository.deleteById(carId);
	}

}
