package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private String serviceName = "Core Library Management Engine";

    public void manageBooks() {
        System.out.println("Service Configured: " + serviceName);
        System.out.println("BookService: Managing Central Library operations...");

        // Fix: Use a valid Spring Data JPA built-in method
        long bookCount = bookRepository.count();
        System.out.println("Total books in database: " + bookCount);
    }
}