package com.example.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.Book;
import com.example.project.Repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    public BookRepository bookRepository;

     public void save(Book b) {
        bookRepository.save(b);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
}
