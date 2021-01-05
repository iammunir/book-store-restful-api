package com.github.iammunir.bookstorerestfulapi.service.implementation;

import com.github.iammunir.bookstorerestfulapi.entity.Book;
import com.github.iammunir.bookstorerestfulapi.model.BookResponse;
import com.github.iammunir.bookstorerestfulapi.model.CreateBookRequest;
import com.github.iammunir.bookstorerestfulapi.repository.BookRepository;
import com.github.iammunir.bookstorerestfulapi.service.BookService;
import com.github.iammunir.bookstorerestfulapi.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ValidationUtil validationUtil) {
        this.bookRepository = bookRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public BookResponse create(CreateBookRequest createBookRequest) {

        validationUtil.validate(createBookRequest);

        String id = UUID.randomUUID().toString();
        Book book = new Book(
                id,
                createBookRequest.getTitle(),
                createBookRequest.getAuthor(),
                createBookRequest.getPrice(),
                createBookRequest.getStock(),
                new Date(),
                null
                );

        bookRepository.save(book);

        return convertBookToBookResponse(book);
    }

    @Override
    public BookResponse get(String id) {

        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isEmpty()) {
            return null;
        } else {
            Book book = bookOptional.get();
            return convertBookToBookResponse(book);
        }
    }

    private BookResponse convertBookToBookResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getStock(),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }
}
