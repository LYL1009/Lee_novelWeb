package com.lee.service;

import com.lee.entity.Novel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NovelService {

    /**
     * 获取排行前十三的完本小说
     * @return
     */
    default List<Novel> getCompleteNovelsByTopThirteen() {
        return null;
    }

    /**
     * 获取排行前六的小说
     * @return
     */
    default List<Novel> getNovelsByTopSix() {
        return null;
    }

    /**
     * 获取各类型排行第一的小说
     * @param type
     * @return
     */
    default Novel getTypeNovelByTopOne(String type) {
        return null;
    }

    /**
     * 获取各类型排行第二到第十三的小说
     * @param type
     * @return
     */
    default List<Novel> getTypeNovelsByTwoToThirteen(String type) {
        return null;
    }

    /**
     * 获取最新发布的小说
     * @return
     */
    default List<Novel> getNovelsByNew() {
        return null;
    }

    /**
     * 获取最新更新的小说
     * @return
     */
    default List<Novel> getNovelsByNewUpdate() {
        return null;
    }

    /**
     * 获取各类型的小说
     * @param type
     * @return
     */
    default List<Novel> getTypeNovels(String type) {
        return null;
    }

    /**
     * 获取所有完本小说
     * @return
     */
    default List<Novel> getCompleteNovels() {
        return null;
    }

    /**
     * 根据浏览量获取小说
     * @param num
     * @return
     */
    default List<Novel> getNovelsByViews(Integer num) {
        return null;
    }

    /**
     * 获取全部的小说
     * @return
     */
    default List<Novel> getNovels() {
        return null;
    }

    /**
     * 通过条件查询类型小说
     * @param type 小说类型
     * @param tag 小说排序方式
     * @param words 小说字数
     * @param status 小说状态
     * @param is_reverse 是否倒序
     * @return
     */
    default List<Novel> getTypeNovelsByConditions(String type, String tag, Integer words, Integer status, Integer is_reverse) {
        return null;
    }

    /**
     * 通过条件查找出全本小说，和所有小说，并可通过条件查询
     * @param is_complete 小说是否完结
     * @param tag 小说排序方式
     * @param words 小说字数
     * @param is_reverse 是否倒序
     * @return
     */
    default List<Novel> getNovelsByTag(Integer is_complete,String tag,Integer words,Integer is_reverse) {
        return null;
    }

    /**
     * 根据搜索框字段搜索小说
     * @param field
     * @return
     */
    default List<Novel> searchNovelsByField(String field) {
        return null;
    }

    /**
     * 根据小说id查询小说
     * @param novelId
     * @return
     */
    default Novel getNovelByNovelId(Integer novelId) {
        return null;
    }

    /**
     * 根据作者id查询小说
     * @param authorId
     * @return
     */
    default List<Novel> getNovelByAuthorId(Integer authorId) {
        return null;
    }

    /**
     * 通过小说id修改小说内容（可选择性修改）
     * @param novel
     * @return
     */
    default Integer updateNovelBySelective(Novel novel) {
        return null;
    }

    /**
     * 通过小说id删除小说
     * @param novelId
     * @return
     */
    default Integer deleteNovelByNovelId(Integer novelId) {
        return null;
    }

    /**
     * 发布小说
     * @param novel
     */
    default Integer publishNovel(Novel novel) {
        return null;
    }
}
