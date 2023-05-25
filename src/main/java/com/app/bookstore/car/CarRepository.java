package com.app.bookstore.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

	List<Car> findByModel(String model);

}
