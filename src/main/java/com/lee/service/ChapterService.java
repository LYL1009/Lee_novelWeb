package com.lee.service;

import com.lee.entity.Chapter;

import java.util.List;

public interface ChapterService {

    /**
     * 通过小说id查询小说应有的章节
     * @param novelId 小说id
     * @return
     */
    default List<Chapter> getChaptersByNovelId(Integer novelId) {
        return null;
    }

    default Integer getNewUpdateChapterIdByNovelId(Integer novelId) {
        return null;
    }

    default Integer getFirstChapterIdByNovelId(Integer novelId) {
        return null;
    }

    default Chapter getChapterByChapterId(Integer chapterId) {
        return null;
    }

    default Integer getNovelChapterNumByNovelId(Integer novelId) {
        return null;
    }

    default Integer deleteByNovelId(Integer novelId) {
        return null;
    }

    default Integer publishChapter(Chapter chapter) {
        return null;
    }

    default Chapter getChapterByChapterName(String chapterName) {
        return null;
    }

    default Integer deleteChapterByChapterId(Integer chapterId) {
        return null;
    }

}
