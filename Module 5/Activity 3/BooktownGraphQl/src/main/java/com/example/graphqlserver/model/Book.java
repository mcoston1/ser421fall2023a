package com.example.graphqlserver.model;


import jakarta.persistence.*;


@Entity
@Table(name = "books")
public class Book {

    public Book(String isbn, String title, int authorId) {
        this.isbn = isbn;
        this.title = title;
        this.authorId = authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Id
    private String isbn;

    @Column(name = "title")
    private String title;

    @JoinColumn(name = "authorId", referencedColumnName = "id")
    private int authorId;
}
