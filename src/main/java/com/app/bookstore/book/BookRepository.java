package com.app.bookstore.book;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
	/*
	 * pagina 3, 50 de elemente
pagina 1: offset 0, limit 50
pagina 2: offset 50, limit 50
pagina 3: offset 100, limit 50
daca numerotarea de pe UI incepe de la 1 (pt page number)
atunci formula e asa:
offset = (pageNumber - 1) * pageSize, limit = pageSize
	 */

	List<Book> findByTitle(String title);
	
//  select b from book b order by b.id asc LIMIT :pageSize OFFSET :pageNumber
//	List<Book> findAllByPageSize(@Param("pageNumber") Integer pageNumber, @Param("pageSize") Integer pageSize);
	
	@Query(value = "select b from book b order by b.id asc")
	List<Book> findAllByPageSize(Pageable page);

}
