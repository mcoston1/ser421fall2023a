package com.example.graphqlserver.repository;

import com.example.graphqlserver.model.Author;
import com.example.graphqlserver.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, int> {
    
}


// @Repository
// public class AuthorRepository {
//     private static ArrayList<Author> dummyAuthors = new ArrayList<>();

//     static {
//         Author author1 = new Author(0, "Robert", "Frost", BookRepository.getBooksByAuthorId(0));
//         Author author2 = new Author(1, "Martin", "Fowler", BookRepository.getBooksByAuthorId(1));
//         Author author3 = new Author(2, "Kevin", "Gary", BookRepository.getBooksByAuthorId(2));

//         dummyAuthors.addAll(Arrays.asList(author1, author2, author3));
//     }

//     public List<Author> getAuthors() {
//         return dummyAuthors;
//     }

//     public Author getAuthorById(int id) {
//         for (Author author : dummyAuthors) {
//             if (author.getId() == id) {
//                 return author;
//             }
//         }
//         return null;
//     }

//     public Author save(String firstName, String lastName) {
//         List<Book> book = new ArrayList<>();
//         int nextId = dummyAuthors.isEmpty() ? 0 : dummyAuthors.get(dummyAuthors.size() - 1).getId() + 1;
//         Author newAuthor = new Author(nextId, firstName, lastName, book);
//         dummyAuthors.add(newAuthor);
//         return newAuthor;
//     }

//     public List<Author> getAuthorByLastName(String lastName) {
//         List<Author> lastAuth = new ArrayList<>();
//         for (Author author: dummyAuthors) {
//             if(author.getLastName().equalsIgnoreCase(lastName)) {
//                 lastAuth.add(author);
//             }
//         }
//         return lastAuth;
//     }

//     public ArrayList<Integer> getAuthorIDByFirstName(String firstName) {
//         ArrayList<Integer> lastAuth = new ArrayList<>();
//         for (Author author: dummyAuthors) {
//             if(author.getFirstName().equalsIgnoreCase(firstName)) {
//                 lastAuth.add(author.getId());
//             }
//         }
//         return lastAuth;
//     }

//     public String updateAuthorFirstNameById(String newFirstName, int authorId) {
//         String oldFirstName;
//         for(Author author: dummyAuthors) {
//             if (author.getId() == authorId) {
//                 oldFirstName = author.getFirstName();
//                 String oldLastName = author.getLastName();
//                 int nId = author.getId();
//                 List<Book> books = author.getBooks();

//                 Author newlyNamed = new Author(nId, newFirstName, oldLastName, books);
//                 dummyAuthors.remove(author);
//                 dummyAuthors.add(newlyNamed);
//                 return oldFirstName;
//             }
//         }
//         return null;
//     }
// }
