package ru.akiselev.library.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private int id;
    @NotEmpty(message = "FIO must be entered")
    private String fio;

    @Min(value = 1900, message = "Year of birth must be > 1900")
    private int yearOfBirth;

    public Person() {}

    public Person(int id, String fio, int yearOfBirth) {
        this.id = id;
        this.fio = fio;
        this.yearOfBirth = yearOfBirth;
    }
}
