package com.example.graphqlserver.dto.input;

public record UpdateAuthorFirstNameInput(String newFirstName, int authorId) {
}