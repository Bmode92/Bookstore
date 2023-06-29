package com.app.bookstore.exemplary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {

	List<Exemplary> findByCode(String code);

	@Query("SELECT e FROM exemplary e LEFT JOIN e.book b ON b.id = :bookId")
	List<Exemplary> findExemplariesByBookId(@Param("bookId") Integer bookId);
}
