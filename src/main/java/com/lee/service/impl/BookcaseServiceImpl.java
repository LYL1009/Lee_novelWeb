package com.lee.service.impl;

import com.lee.entity.Bookcase;
import com.lee.entity.BookcaseExample;
import com.lee.mapper.BookcaseMapper;
import com.lee.service.BookcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookcaseServiceImpl implements BookcaseService {

    @Autowired
    private BookcaseMapper bookcaseMapper;

    @Override
    public List<Bookcase> getBookcases() {
        return bookcaseMapper.selectByExample(new BookcaseExample());
    }

    @Override
    public List<Bookcase> getBookcasesByUserId(Integer userId) {
        return bookcaseMapper.selectBookcasesByUserId(userId);
    }

    @Override
    public Integer addBookcase(Bookcase bookcase) {
        return bookcaseMapper.insert(bookcase);
    }

    @Override
    public Integer updateBookcase(Bookcase bookcase,Integer userId) {
        List<Bookcase> bookcases = getBookcasesByUserId(userId);
        for (Bookcase b:bookcases) {
            if (b.getNovelId().equals(bookcase.getNovelId())) {
                bookcase.setBookcaseId(b.getBookcaseId());
                return bookcaseMapper.updateByPrimaryKey(bookcase);
            }
        }
        return null;
    }

    @Override
    public Integer removeBookcaseRecord(Integer bookcaseId) {
        return bookcaseMapper.deleteByPrimaryKey(bookcaseId);
    }

    @Override
    public Integer deleteByNovelId(Integer novelId) {
        return bookcaseMapper.deleteByNovelId(novelId);
    }
}
