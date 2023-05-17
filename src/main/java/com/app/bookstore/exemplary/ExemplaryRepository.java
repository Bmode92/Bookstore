package com.app.bookstore.exemplary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {

	List<Exemplary> findByCode(String code);
}
