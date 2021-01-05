package com.github.iammunir.bookstorerestfulapi.repository;

import com.github.iammunir.bookstorerestfulapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}
