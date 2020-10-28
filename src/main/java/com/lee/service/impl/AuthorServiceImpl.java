package com.lee.service.impl;

import com.lee.entity.Author;
import com.lee.entity.AuthorExample;
import com.lee.mapper.AuthorMapper;
import com.lee.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<Author> getAuthors() {
        return authorMapper.selectByExample(new AuthorExample());
    }

    @Override
    public Author getAuthorByUserId(Integer userId) {
        return authorMapper.selectAuthorByUserId(userId);
    }

    @Override
    public Integer becomeAuthor(Author author) {
        List<Author> authors = getAuthors();
        for (Author a:authors) {
            if (a.getUserId().equals(author.getUserId())) {
                return null;
            } else if (a.getAuthorName().equals(author.getAuthorName())) {
                return 0;
            }
        }
        return authorMapper.insertSelective(author);
    }
}
