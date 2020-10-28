package com.lee.service.impl;

import com.lee.entity.Detail;
import com.lee.mapper.DetailMapper;
import com.lee.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailMapper detailMapper;

    @Override
    public Detail getChapterDetailByChapterId(Integer chapterId) {
        return detailMapper.selectChapterDetailByChapterId(chapterId);
    }

    @Override
    public Integer getNewChapterIdByNovelIdAndChapterIdAndTurn(Integer chapterId, Integer novelId, Integer turn) {
        return detailMapper.selectNewChapterIdByNovelIdAndChapterIdAndTurn(chapterId, novelId, turn);
    }

    @Override
    public Integer deleteByNovelId(Integer novelId) {
        return detailMapper.deleteByNovelId(novelId);
    }

    @Override
    public Integer publishChapter(Detail detail) {
        return detailMapper.insertSelective(detail);
    }

    @Override
    public Integer deleteDetailByChapterId(Integer chapterId) {
        return detailMapper.deleteDetailByChapterId(chapterId);
    }
}
