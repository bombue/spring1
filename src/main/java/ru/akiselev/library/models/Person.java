package ru.akiselev.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "FIO must be entered")
    @Column(name = "fio")
    private String fio;

    @Min(value = 1900, message = "Year of birth must be > 1900")
    @Column(name = "yearofbirth")
    private int yearOfBirth;

    @OneToMany(mappedBy = "owner")
    private List<Book> bookList = new ArrayList<>();

    public Person() {}

    public Person(String fio, int yearOfBirth) {
        this.fio = fio;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
