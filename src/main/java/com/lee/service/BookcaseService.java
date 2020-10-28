package com.lee.service;

import com.lee.entity.Bookcase;

import java.util.List;

public interface BookcaseService {

    default List<Bookcase> getBookcases() {
        return null;
    }

    default List<Bookcase> getBookcasesByUserId(Integer userId) {
        return null;
    }

    default Integer addBookcase(Bookcase bookcase) {
        return null;
    }

    default Integer updateBookcase(Bookcase bookcase,Integer userId) {
        return null;
    }

    default Integer removeBookcaseRecord(Integer bookcaseId) {
        return null;
    }

    default Integer deleteByNovelId(Integer novelId) {
        return null;
    }
}
