package com.lee.service.impl;

import com.lee.entity.Chapter;
import com.lee.mapper.ChapterMapper;
import com.lee.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public List<Chapter> getChaptersByNovelId(Integer novelId) {
        return chapterMapper.selectChaptersByNovelId(novelId);
    }

    @Override
    public Integer getNewUpdateChapterIdByNovelId(Integer novelId) {
        return chapterMapper.selectNewUpdateChapterIdByNovelId(novelId);
    }

    @Override
    public Integer getFirstChapterIdByNovelId(Integer novelId) {
        return chapterMapper.selectFirstChapterIdByNovelId(novelId);
    }

    @Override
    public Chapter getChapterByChapterId(Integer chapterId) {
        return chapterMapper.selectByPrimaryKey(chapterId);
    }

    @Override
    public Integer getNovelChapterNumByNovelId(Integer novelId) {
        return chapterMapper.selectNovelChapterNumByNovelId(novelId);
    }

    @Override
    public Integer deleteByNovelId(Integer novelId) {
        return chapterMapper.deleteByNovelId(novelId);
    }

    @Override
    public Integer publishChapter(Chapter chapter) {
        return chapterMapper.insertSelective(chapter);
    }

    @Override
    public Chapter getChapterByChapterName(String chapterName) {
        return chapterMapper.selectChapterByChapterName(chapterName);
    }

    @Override
    public Integer deleteChapterByChapterId(Integer chapterId) {
        return chapterMapper.deleteByPrimaryKey(chapterId);
    }
}
