package com.app.bookstore.car.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.bookstore.car.Car;
import com.app.bookstore.car.dto.CarCreateDTO;
import com.app.bookstore.car.dto.CarGetDTO;

@Component
public class CarMapper {

	public Car carCreateDTO2Car(CarCreateDTO carCreateDTO) {
		Car car = new Car();
		car.setMarca(carCreateDTO.getMarca());
		car.setModel(carCreateDTO.getModel());
		car.setDataFabricatie(carCreateDTO.getDataFabricatie());
		car.setCaiPutere(carCreateDTO.getCaiPutere());

		return car;
	}

	public CarGetDTO car2carGetDTO(Car car) {
		CarGetDTO carGetDTO = new CarGetDTO();
		carGetDTO.setId(car.getId());
		carGetDTO.setMarca(car.getMarca());
		carGetDTO.setModel(car.getModel());
		carGetDTO.setDataFabricatie(car.getDataFabricatie());
		carGetDTO.setCaiPutere(car.getCaiPutere());

		return carGetDTO;
	}

	public List<CarGetDTO> listCar2listGetDTO(List<Car> cars) {
		return cars.stream().map(car -> car2carGetDTO(car)).toList();
	}

}
