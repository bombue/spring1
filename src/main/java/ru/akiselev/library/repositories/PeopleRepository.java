package ru.akiselev.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akiselev.library.models.Person;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
