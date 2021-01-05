package com.github.iammunir.bookstorerestfulapi.service;

import com.github.iammunir.bookstorerestfulapi.model.BookResponse;
import com.github.iammunir.bookstorerestfulapi.model.CreateBookRequest;

public interface BookService {

    public BookResponse create(CreateBookRequest createBookRequest);

    public BookResponse get(String id);

}
