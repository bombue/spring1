package ru.akiselev.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akiselev.library.models.Book;
import ru.akiselev.library.models.Person;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByNameStartingWith(String name);
}
