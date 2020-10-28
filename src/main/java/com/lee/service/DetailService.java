package com.lee.service;

import com.lee.entity.Detail;
import org.apache.ibatis.annotations.Param;

public interface DetailService {

    default Detail getChapterDetailByChapterId(Integer chapterId) {
        return null;
    }

    default Integer getNewChapterIdByNovelIdAndChapterIdAndTurn(Integer chapterId, Integer novelId,Integer turn) {
        return null;
    }

    default Integer deleteByNovelId(Integer novelId) {
        return null;
    }

    default Integer publishChapter(Detail detail) {
        return null;
    }

    default Integer deleteDetailByChapterId(Integer chapterId) {
        return null;
    }
}
