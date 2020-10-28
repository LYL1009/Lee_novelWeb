package com.lee.mapper;

import com.lee.entity.*;
import com.lee.service.*;
import com.lee.util.DateUtil;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.logging.XMLFormatter;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class NovelMapperTest {

    @Autowired
    NovelMapper novelMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    NovelService novelService;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    DetailMapper detailMapper;

    @Autowired
    DetailService detailService;

    @Autowired
    HistoryMapper historyMapper;

    @Autowired
    HistoryService historyService;

    @Autowired
    BookcaseMapper bookcaseMapper;

    @Autowired
    AuthorMapper authorMapper;

    @Autowired
    AuthorService authorService;

    @Autowired
    ChapterService chapterService;

    @Test
    public void test18() {
        Detail detail = detailService.getChapterDetailByChapterId(15);
        if (detail == null) {
            System.out.println(detail);
        }
        System.out.println(detail);
    }

    @Test
    public void test17() {
        Chapter chapter = new Chapter(null, null, "爱你的颜色", null, null,
                new Date(), null);
        Integer i1 = chapterService.publishChapter(chapter);
        if (i1 != null) {
            Chapter chapterId = chapterService.getChapterByChapterName("爱你的颜色");
            System.out.println(chapterId);
        }
    }

    @Test
    public void test16() {
        /*List<Chapter> chapters = chapterService.getChaptersByNovelId(130);
        System.out.println(chapters);*/
        System.out.println(chapterMapper.selectChapterByChapterName("第三章 测试"));
    }

    @Test
    public void test15() {
        Integer i = novelService.updateNovelBySelective(new Novel(127, null, null, 5, 1, null, null, null, null, null, null, null, null, null, null));
        System.out.println(i);
    }

    @Test
    public void test14() {
        Integer i = authorService.becomeAuthor(new Author(null, "邵帅", 2));
        System.out.println(i);
        System.out.println(chapterMapper.selectFirstChapterIdByNovelId(13));
    }

    @Test
    public void test13() {
        int insert = bookcaseMapper.updateByPrimaryKey(new Bookcase(2, 13, 1, 1, 55));
        System.out.println(insert);

        Bookcase bookcase = bookcaseMapper.selectByPrimaryKey(1);
        System.out.println(bookcase);
    }

    @Test
    public void test12() {
        int i = 0;
        History history = new History(null, 1, 1, 60, new Date(), 1);
        List<History> novelHistories = historyService.getNovelHistories();
        for (History h : novelHistories) {
            if (h.getNovelId().equals(history.getNovelId())) {
                history.setHistoryId(h.getHistoryId());
                i = historyMapper.updateByPrimaryKey(history);
            }
        }
        System.out.println(i);
    }

    @Test
    public void test11() {
        List<History> novelHistories = historyService.getNovelHistories();
        for (History history : novelHistories) {
            System.out.println(DateUtil.date2String(history.getLastReadTime()));
        }

//        Integer i = historyService.addNovelHistory(new History(null, 1, 1, 60, new Date(), 1));
//        System.out.println(i);
    }

    @Test
    public void test10() {
        int history = historyMapper.insert(new History(null, 1, 1, 1, new Date(), 1));
        System.out.println(history);
        System.out.println(DateUtil.date2String(new Date()));
    }

    @Test
    public void test09() {
        /*Integer chapterId = detailMapper.selectNewChapterIdByNovelIdAndChapterIdAndTurn(5, 13, 0);
        System.out.println(chapterId);*/
        Integer newUpdateChapterId = chapterMapper.selectNewUpdateChapterIdByNovelId(13);
        System.out.println(newUpdateChapterId);
    }

    @Test
    public void test08() {
        Detail detail = detailService.getChapterDetailByChapterId(2);
        System.out.println(detail);
        Novel novel = novelService.getNovelByNovelId(detail.getNovelId());
        System.out.println(novel);
    }

    @Test
    public void test07() {
        List<Chapter> chapters = chapterMapper.selectChaptersByNovelId(1);
        for (Chapter chapter : chapters) {
            System.out.println(chapter);
        }
        System.out.println(novelMapper.selectNovelByNovelId(13));
    }

    @Test
    public void test06() {
        String field = "%元%";
        List<Novel> novels = novelMapper.searchNovelsByField(field);
        for (Novel novel : novels) {
            System.out.println(novel);
        }
    }

    @Test
    public void test05() {
        List<Novel> novels = novelMapper.selectNovelsByTag(0, null, 0, 0);
        for (Novel novel : novels) {
            System.out.println(novel);
        }
    }

    @Test
    public void test04() {
        List<Novel> novels = novelMapper.selectNovelsByConditions("玄幻", null, 0, 0, 0);
        for (Novel novel : novels) {
            System.out.println(novel);
        }
    }

    @Test
    public void test03() {
        List<Tag> tags = tagMapper.selectByExample(new TagExample());
        System.out.println(tags);
    }

    @Test
    public void test02() {
        /*List<Novel> novels = novelMapper.selectNovelsByViews(3);
        for (Novel novel:novels) {
            System.out.println(novel);
        }
        System.out.println(novels.get(0));
        System.out.println(novels.get(1));
        System.out.println(novels.get(2));*/
        List<Novel> novels = novelMapper.selectByExample(new NovelExample());
        for (Novel novel : novels) {
            System.out.println(novel);
        }
    }

    @Test
    public void test01() {
        /*List<Novel> novels = novelMapper.selectNovelsByTopSix();
        System.out.println(novels);*/
        /*List<Novel> novels = novelMapper.selectCompleteNovelsByTopThirteen();
        for (Novel novel:novels) {
            System.out.println(novel);
        }*/
        /*Novel novel = novelMapper.selectTypeNovelByTopOne("都市");
        System.out.println(novel);*/
        /*List<Novel> novels = novelMapper.selectTypeNovelsByTwoToThirteen("玄幻");
        for (Novel novel:novels) {
            System.out.println(novel);
        }*/
        /*List<Novel> novels = novelMapper.selectNovelsByNew();
        for (Novel novel:novels) {
            System.out.println(novel);
            System.out.println(DateUtil.date2String(novel.getUpdateTime()));
        }*/
        List<Novel> novels = novelMapper.selectCompleteNovels();
        for (Novel novel : novels) {
            System.out.println(novel);
        }
    }

}
