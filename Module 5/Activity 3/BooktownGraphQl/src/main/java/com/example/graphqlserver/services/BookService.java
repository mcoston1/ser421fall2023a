package com.example.graphqlserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.graphqlserver.model.Book;
import com.example.graphqlserver.repository.BookRepository;

@Service
public class BookService {
    private static BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    public Book getBookByISBN(String isbn) {
        for (Book book : bookRepository.findAll()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Book save(String isbn, String title, int authorId) {
        Book newBook = new Book(isbn, title, authorId);
        this.getBooks().add(newBook);
        return newBook;
    }

    public static ArrayList<Book> getBooksByAuthorId(int id) {
        ArrayList<Book> bookList = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            if (book.getAuthorId() == id) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public ArrayList<String> getTitleList(ArrayList<Integer> authorIDs) {
        ArrayList<String> titles = new ArrayList<>();
        for (Integer authid: authorIDs) {
            ArrayList<Book> bookList = getBooksByAuthorId(authid);
            for(Book book: bookList) {
                titles.add(book.getTitle());
            }
        }
        return titles;
    }

    public String deleteBookByISBN(String ISBN) {
        for (Book book: bookRepository.findAll()) {
            if (book.getIsbn() == ISBN) {
                this.getBooks().remove(book);
                return ISBN;
            }
        }
        return null;
    }

}









