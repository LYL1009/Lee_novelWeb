package com.lee.mapper;

import com.lee.entity.Chapter;
import com.lee.entity.ChapterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChapterMapper {
    long countByExample(ChapterExample example);

    int deleteByExample(ChapterExample example);

    int deleteByNovelId(Integer novelId);

    int deleteByPrimaryKey(Integer chapterId);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    /**
     * 通过小说id查询该小说应有的章节
     * @param novelId
     * @return
     */
    List<Chapter> selectChaptersByNovelId(Integer novelId);

    Integer selectNewUpdateChapterIdByNovelId(Integer novelId);

    Integer selectFirstChapterIdByNovelId(Integer novelId);

    Integer selectNovelChapterNumByNovelId(Integer novelId);

    Chapter selectChapterByChapterName(String chapterName);

    List<Chapter> selectByExample(ChapterExample example);

    Chapter selectByPrimaryKey(Integer chapterId);

    int updateByExampleSelective(@Param("record") Chapter record, @Param("example") ChapterExample example);

    int updateByExample(@Param("record") Chapter record, @Param("example") ChapterExample example);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
}