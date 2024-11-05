package ru.akiselev.library.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private int id;
    private int person_id;

    @NotEmpty(message = "Book name must be entered")
    private String name;
    @NotEmpty(message = "Book author must be entered")
    private String author;
    @Min(value = 1900, message = "Year of publish must be > 1900")
    private int yearOfPublish;

    public Book(int id, int person_id, String name, String author, int yearOfPublish) {
        this.id = id;
        this.person_id = person_id;
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }
}
