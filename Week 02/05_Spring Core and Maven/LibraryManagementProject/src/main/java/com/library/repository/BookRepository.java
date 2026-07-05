package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Spring Data JPA provides all CRUD logic automatically out-of-the-box!
public interface BookRepository extends JpaRepository<Book, Long> {
}