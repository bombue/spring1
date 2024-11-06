package ru.akiselev.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.akiselev.library.models.Book;
import ru.akiselev.library.models.Person;

import java.util.List;

@Component
public class PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("select * from person where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("update person set fio=?, yearOfBirth=? where id=?", person.getFio(), person.getYearOfBirth(), id);
    }

    public void create(Person person) {
        jdbcTemplate.update("insert into person (fio, yearOfBirth) values (?, ?);", person.getFio(), person.getYearOfBirth());
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from Person where id=?", id);
    }

    public List<Book> getBooks(int id) {
        return jdbcTemplate.query("select * from book where person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}
