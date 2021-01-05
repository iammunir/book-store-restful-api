package com.github.iammunir.bookstorerestfulapi.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateBookRequest {

    @NotBlank
    private String title;

    private String author;

    @NotNull
    @Min(value = 1)
    private Long price;

    @NotNull
    @Min(value = 0)
    private Integer stock;

    public CreateBookRequest(String title, String author, Long price, Integer stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
