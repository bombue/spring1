package ru.akiselev.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.akiselev.library.models.Book;

import java.util.List;

@Component
public class BookDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("select * from Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("select * from Book where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("update Book set person_id=?, name=?, author=?, yearOfPublish=? where id=?", book.getPerson_id(), book.getName(), book.getAuthor(), book.getYearOfPublish(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from Book where id=?", id);
    }

    public void create(Book book) {
        jdbcTemplate.update("insert into Book (person_id, name, author, yearOfPublish) values (?, ?, ?, ?)", book.getPerson_id(), book.getName(), book.getAuthor(), book.getYearOfPublish());
    }

}
