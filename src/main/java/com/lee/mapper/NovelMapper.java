package com.lee.mapper;

import com.lee.entity.Novel;
import com.lee.entity.NovelExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NovelMapper {
    long countByExample(NovelExample example);

    int deleteByExample(NovelExample example);

    int deleteByPrimaryKey(Integer novelId);

    int insert(Novel record);

    int insertSelective(Novel record);

    List<Novel> selectByExample(NovelExample example);

    List<Novel> selectNovelsByTopSix();

    List<Novel> selectCompleteNovelsByTopThirteen();

    Novel selectTypeNovelByTopOne(String type);

    List<Novel> selectTypeNovelsByTwoToThirteen(String type);

    List<Novel> selectNovelsByNew();

    List<Novel> selectNovelsByNewUpdate();

    List<Novel> selectTypeNovels(String type);

    List<Novel> selectCompleteNovels();

    List<Novel> selectNovelsByViews(Integer num);

    List<Novel> selectNovelsByConditions(@Param("type") String type, @Param("tag") String tag, @Param("words") Integer words,
                                         @Param("status") Integer status, @Param("is_reverse") Integer is_reverse);

    List<Novel> selectNovelsByTag(@Param("is_complete") Integer is_complete, @Param("tag") String tag,
                                  @Param("words") Integer words, @Param("is_reverse") Integer is_reverse);

    List<Novel> searchNovelsByField(String field);

    Novel selectNovelByNovelId(Integer novelId);

    List<Novel> selectNovelByAuthorId(Integer authorId);

    Novel selectByPrimaryKey(Integer novelId);

    int updateByExampleSelective(@Param("record") Novel record, @Param("example") NovelExample example);

    int updateByExample(@Param("record") Novel record, @Param("example") NovelExample example);

    int updateByPrimaryKeySelective(Novel record);

    int updateByPrimaryKey(Novel record);

}