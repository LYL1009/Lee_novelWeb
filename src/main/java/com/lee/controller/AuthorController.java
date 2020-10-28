package com.lee.controller;

import com.lee.entity.Author;
import com.lee.entity.Chapter;
import com.lee.entity.Detail;
import com.lee.entity.Novel;
import com.lee.service.*;
import com.lee.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AuthorController {

    @Autowired
    private NovelService novelService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private DetailService detailService;

    @Autowired
    private BookcaseService bookcaseService;

    @Autowired
    private HistoryService historyService;

    @GetMapping("/author/toMyOwnNovelPage")
    public String toMyNovelPage(HttpSession session, Model model) {
        Map<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, String> novelReleaseTime = new HashMap<>();
        Author author = (Author) session.getAttribute("author");
        if (author != null) {
            List<Novel> novels = novelService.getNovelByAuthorId(author.getAuthorId());
            for (Novel novel : novels) {
                map.put(novel.getNovelId(), chapterService.getNovelChapterNumByNovelId(novel.getNovelId()));
                if (novel.getReleaseTime() != null) {
                    novelReleaseTime.put(novel.getNovelId(), DateUtil.date2String(novel.getReleaseTime()));
                } else {
                    novelReleaseTime.put(novel.getNovelId(), null);
                }
            }
            model.addAttribute("novels", novels).addAttribute("map", map).addAttribute("novelReleaseTime", novelReleaseTime);
        }
        return "user/author/myOwnNovel";
    }

    @GetMapping("/author/toUpdateNovelPage")
    public String toUpdateNovelPage(HttpSession session, Model model) {
        Map<Integer, Integer> map = new HashMap<>();
        Author author = (Author) session.getAttribute("author");
        if (author != null) {
            List<Novel> novels = novelService.getNovelByAuthorId(author.getAuthorId());
            for (Novel novel : novels) {
                map.put(novel.getNovelId(), chapterService.getNovelChapterNumByNovelId(novel.getNovelId()));
            }
            model.addAttribute("novels", novels).addAttribute("map", map);
        }
        return "user/author/updateNovel";
    }

    @GetMapping("/author/toNovelChapterPage")
    public String toNovelChapterPage(HttpSession session, Model model) {
        Map<Integer, Integer> map = new HashMap<>();
        Author author = (Author) session.getAttribute("author");
        if (author != null) {
            List<Novel> novels = novelService.getNovelByAuthorId(author.getAuthorId());
            for (Novel novel : novels) {
                map.put(novel.getNovelId(), chapterService.getNovelChapterNumByNovelId(novel.getNovelId()));
            }
            model.addAttribute("novels", novels).addAttribute("map", map);
        }
        return "user/author/novelChapter";
    }

    @GetMapping("/author/updateNovelChapter")
    public String updateNovelChapter(Integer novelId, HttpSession session, Model model) {
        Author author = (Author) session.getAttribute("author");
        if (author != null && novelId != null) {
            Novel novel = novelService.getNovelByNovelId(novelId);
            Integer chapterNumber = chapterService.getNovelChapterNumByNovelId(novelId);
            model.addAttribute("novel", novel).addAttribute("chapterNumber", chapterNumber);
        }
        return "user/author/updateNovelChapter";
    }

    @GetMapping("/author/chapter_list")
    public String getChapterListByNovelId(Integer novelId, Model model) {
        HashMap<Integer, String> updateTimes = new HashMap<>();
        List<Chapter> chapters = chapterService.getChaptersByNovelId(novelId);
        Novel novel = novelService.getNovelByNovelId(novelId);
        model.addAttribute("novel", novel);
        if (chapters != null && chapters.size() > 0) {
            for (Chapter chapter : chapters) {
                updateTimes.put(chapter.getChapterId(), DateUtil.date2String(chapter.getUpdateTime()));
            }
            model.addAttribute("chapters", chapters).addAttribute("updateTimes", updateTimes);
        } else {
            model.addAttribute("chapters", null);
        }
        return "user/author/chapterList";
    }

    @GetMapping("/author/toEditNovelPage")
    public String toEditNovelPage(Integer novelId, Model model) {
        Integer value = null;
        Novel novel = novelService.getNovelByNovelId(novelId);
        if ("玄幻".equals(novel.getType())) {
            value = 0;
        } else if ("仙侠".equals(novel.getType())) {
            value = 1;
        } else if ("都市".equals(novel.getType())) {
            value = 2;
        } else if ("历史".equals(novel.getType())) {
            value = 3;
        } else if ("网游".equals(novel.getType())) {
            value = 4;
        } else if ("科幻".equals(novel.getType())) {
            value = 5;
        } else if ("恐怖".equals(novel.getType())) {
            value = 6;
        } else if ("言情".equals(novel.getType())) {
            value = 7;
        } else if ("其他".equals(novel.getType())) {
            value = 8;
        }
        model.addAttribute("novel", novel).addAttribute("value", value);
        return "user/author/editNovel";
    }

    @PostMapping("/author/endNovel")
    @ResponseBody
    public String endNovel(Integer novelId, HttpSession session) {
        Author author = (Author) session.getAttribute("author");
        Novel novel = novelService.getNovelByNovelId(novelId);
        Integer i = null;
        if (author.getAuthorId().equals(novel.getAuthorId())) {
            novel.setStatus(1);
            i = novelService.updateNovelBySelective(novel);
            if (i != null) {
                return "success";
            }
        }
        return "error";
    }

    @PostMapping("/author/deleteNovel")
    @ResponseBody
    public String deleteNovel(Integer novelId, HttpSession session) {
        Author author = (Author) session.getAttribute("author");
        Novel novel = novelService.getNovelByNovelId(novelId);
        Integer i = null;
        if (author.getAuthorId().equals(novel.getAuthorId())) {
            i = novelService.deleteNovelByNovelId(novelId);
            chapterService.deleteByNovelId(novelId);
            detailService.deleteByNovelId(novelId);
            bookcaseService.deleteByNovelId(novelId);
            historyService.deleteByNovelId(novelId);
            if (i != null) {
                return "success";
            }
        }
        return "error";
    }

    @PostMapping("/author/publishNovel")
    @ResponseBody
    public String publishNovel(String novelName, String novelType, String novelImage, String novelIntroduction, HttpSession session) {
        Author author = (Author) session.getAttribute("author");
        if (author != null && novelName != null && novelType != null && novelImage != null && novelIntroduction != null) {
            Novel novel = new Novel(null, novelName, author.getAuthorName(), author.getAuthorId(), 0,
                    novelType, null, null, novelIntroduction, 0, 0,
                    0, new Date(), 0, novelImage);
            Integer i = novelService.publishNovel(novel);
            if (i != null) {
                return "success";
            }
        }
        return null;
    }

    @PostMapping("/author/updateChapter")
    @ResponseBody
    public String updateChapter(Integer novelId, String chapterName, String chapterContent, HttpSession session) {
        Author author = (Author) session.getAttribute("author");
        if (author != null && novelId != null && chapterName != null && chapterContent != null) {
            int sequenceId = chapterService.getNovelChapterNumByNovelId(novelId) + 1;
            chapterName = "第" + sequenceId + "章 " + chapterName;
            Novel novel = novelService.getNovelByNovelId(novelId);
            novel.setNewChapter(chapterName);
            novel.setTotalWords(chapterContent.length() + novel.getTotalWords());
            novel.setUpdateTime(new Date());
            Integer i = novelService.updateNovelBySelective(novel);
            if (i != null) {
                Chapter chapter = new Chapter(null, novelId, chapterName, null, chapterContent.length(),
                        new Date(), sequenceId);
                Integer i1 = chapterService.publishChapter(chapter);
                if (i1 != null) {
                    Chapter c = chapterService.getChapterByChapterName(chapterName);
                    if (c != null) {
                        Detail detail = new Detail(null, novelId, chapterName, c.getChapterId(), chapterContent.length(),
                                new Date(), chapterContent);
                        Integer i2 = detailService.publishChapter(detail);
                        if (i2 != null) {
                            return "success";
                        }
                    }
                }
            }
        }
        return null;
    }

    @PostMapping("/author/editNovel")
    @ResponseBody
    public String editNovel(Integer novelId, String novelName, String novelType, String novelImage,
                            String novelIntroduction, HttpSession session) {
        Author author = (Author) session.getAttribute("author");
        if (author != null && novelId != null && novelName != null && novelType != null && novelImage != null && novelIntroduction != null) {
            Novel novel = novelService.getNovelByNovelId(novelId);
            if (author.getAuthorId().equals(novel.getAuthorId())) {
                novel.setNovelName(novelName);
                novel.setType(novelType);
                novel.setNovelImage(novelImage);
                novel.setIntroduction(novelIntroduction);
                Integer i = novelService.updateNovelBySelective(novel);
                if (i != null) {
                    return "success";
                }
            }
        }
        return null;
    }

    @GetMapping("/author/toModifyChapterPage")
    public String toModifyChapterPage(Integer novelId, Integer chapterId, Model model) {
        Novel novel = novelService.getNovelByNovelId(novelId);
        Chapter chapter = chapterService.getChapterByChapterId(chapterId);
        Detail detail = detailService.getChapterDetailByChapterId(chapterId);
        if (novel != null && chapter != null && detail != null) {
            model.addAttribute("novel", novel).addAttribute("chapter", chapter).addAttribute("detail", detail);
        }
        return "user/author/modifyChapter";
    }

    @PostMapping("/author/deleteChapter")
    @ResponseBody
    public String deleteChapter(Integer chapterId,Integer novelId) {
        Integer i1 = chapterService.deleteChapterByChapterId(chapterId);
        Integer i2 = detailService.deleteDetailByChapterId(chapterId);
        if (i1 != null && i2 != null) {
            Novel novel = novelService.getNovelByNovelId(novelId);
            Integer newChapterId = chapterService.getNewUpdateChapterIdByNovelId(novelId);
            Chapter chapter = chapterService.getChapterByChapterId(newChapterId);
            if (!novel.getNewChapter().equals(chapter.getChapterName())) {
                novel.setNewChapter(chapter.getChapterName());
                novel.setUpdateTime(chapter.getUpdateTime());
                Integer i3 = novelService.updateNovelBySelective(novel);
                if (i3 != null) {
                    historyService.deleteByNovelId(novelId);
                    return "success";
                }
            }
        }
        return null;
    }

}
