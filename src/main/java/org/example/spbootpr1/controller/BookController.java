package org.example.spbootpr1.controller;

import lombok.RequiredArgsConstructor;
import org.example.spbootpr1.dto.BookDto;
import org.example.spbootpr1.entity.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/books")
@Controller

public class BookController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping
    public String bookPage(Model model) {
        String sql = "SELECT * FROM book";
        List<Book> books = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Book.class));
        model.addAttribute("books", books);
        model.addAttribute("title", "BOOK PAGE");

        return "book/book";
    }


    @GetMapping("/create")
    public String createBookPage(Model model) {
        model.addAttribute("title", "CREATE BOOK PAGE");
        return "book/create";
    }

    @PostMapping("/create")
    public String bookCreate(@ModelAttribute BookDto bookDto) {
        String sql = "insert into book(name,author) values(?,?)";
        jdbcTemplate.update(sql, bookDto.getName(), bookDto.getAuthor());
        return "redirect:/books";
    }

}
