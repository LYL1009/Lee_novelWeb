package com.lee.service.impl;

import com.lee.entity.Novel;
import com.lee.entity.NovelExample;
import com.lee.mapper.NovelMapper;
import com.lee.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelServiceImpl implements NovelService {

    @Autowired
    private NovelMapper novelMapper;

    @Override
    public List<Novel> getCompleteNovelsByTopThirteen() {
        return novelMapper.selectCompleteNovelsByTopThirteen();
    }

    @Override
    public List<Novel> getNovelsByTopSix() {
        return novelMapper.selectNovelsByTopSix();
    }

    @Override
    public Novel getTypeNovelByTopOne(String type) {
        return novelMapper.selectTypeNovelByTopOne(type);
    }

    @Override
    public List<Novel> getTypeNovelsByTwoToThirteen(String type) {
        return novelMapper.selectTypeNovelsByTwoToThirteen(type);
    }

    @Override
    public List<Novel> getNovelsByNew() {
        return novelMapper.selectNovelsByNew();
    }

    @Override
    public List<Novel> getNovelsByNewUpdate() {
        return novelMapper.selectNovelsByNewUpdate();
    }

    @Override
    public List<Novel> getTypeNovels(String type) {
        return novelMapper.selectTypeNovels(type);
    }

    @Override
    public List<Novel> getCompleteNovels() {
        return novelMapper.selectCompleteNovels();
    }

    @Override
    public List<Novel> getNovelsByViews(Integer num) {
        return novelMapper.selectNovelsByViews(num);
    }

    @Override
    public List<Novel> getNovels() {
        return novelMapper.selectByExample(new NovelExample());
    }

    @Override
    public List<Novel> getTypeNovelsByConditions(String type, String tag, Integer words, Integer status, Integer is_reverse) {
        return novelMapper.selectNovelsByConditions(type,tag,words,status,is_reverse);
    }

    @Override
    public List<Novel> getNovelsByTag(Integer is_complete, String tag, Integer words, Integer is_reverse) {
        return novelMapper.selectNovelsByTag(is_complete,tag,words,is_reverse);
    }

    @Override
    public List<Novel> searchNovelsByField(String field) {
        return novelMapper.searchNovelsByField(field);
    }

    @Override
    public Novel getNovelByNovelId(Integer novelId) {
        return novelMapper.selectNovelByNovelId(novelId);
    }

    @Override
    public List<Novel> getNovelByAuthorId(Integer authorId) {
        return novelMapper.selectNovelByAuthorId(authorId);
    }

    @Override
    public Integer updateNovelBySelective(Novel novel) {
        return novelMapper.updateByPrimaryKeySelective(novel);
    }

    @Override
    public Integer deleteNovelByNovelId(Integer novelId) {
        return novelMapper.deleteByPrimaryKey(novelId);
    }

    @Override
    public Integer publishNovel(Novel novel) {
        return novelMapper.insertSelective(novel);
    }
}
