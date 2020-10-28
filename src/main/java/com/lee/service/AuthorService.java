package com.lee.service;

import com.lee.entity.Author;

import java.util.List;

public interface AuthorService {

    default List<Author> getAuthors() {
        return null;
    }

    default Author getAuthorByUserId(Integer userId) {
        return null;
    }

    default Integer becomeAuthor(Author author) {
        return null;
    }

}
