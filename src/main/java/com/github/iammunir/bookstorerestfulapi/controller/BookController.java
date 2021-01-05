package com.github.iammunir.bookstorerestfulapi.controller;

import com.github.iammunir.bookstorerestfulapi.model.BookResponse;
import com.github.iammunir.bookstorerestfulapi.model.CreateBookRequest;
import com.github.iammunir.bookstorerestfulapi.model.WebResponse;
import com.github.iammunir.bookstorerestfulapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = {"/api/v1/book"}, produces = {"application/json"}, consumes = {"application/json"})
    public WebResponse<BookResponse> createBook(@RequestBody CreateBookRequest createBookRequest) {
        BookResponse bookResponse = bookService.create(createBookRequest);
        return new WebResponse<>(200, "OK", bookResponse);
    }

    @GetMapping(value = {"/api/v1/book/{book_id}"}, produces = {"application/json"})
    public WebResponse<BookResponse> getBook(@PathVariable("book_id") String id) {
        BookResponse bookResponse = bookService.get(id);

        if (bookResponse == null) {
            return new WebResponse<>(404, "NOT FOUND", null);
        } else {
            return new WebResponse<>(200, "OK", bookResponse);
        }
    }

}
