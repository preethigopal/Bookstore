package com.example.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.MyBookList;
import com.example.project.Repository.MyBookRepository;

@Service
public class MyBookService {
    
     
    @Autowired
	private MyBookRepository mybook;
	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}

    public void deleteById(int id) {
		mybook.deleteById(id);
	}
}
