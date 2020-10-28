package com.lee.controller;

import com.lee.entity.*;
import com.lee.service.*;
import com.lee.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NovelController {

    @Autowired
    private NovelService novelService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private DetailService detailService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private BookcaseService bookcaseService;

    /**
     * 显示首页的小说信息
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String getAllNovel(Model model) {
        // 查询排名前十三的完本小说
        List<Novel> novels = novelService.getCompleteNovelsByTopThirteen();
        // 查询经典完本小说前六
        List<Novel> novelsByTopSix = novelService.getNovelsByTopSix();
        model.addAttribute("novels", novels);
        model.addAttribute("novelsByTopSix", novelsByTopSix);

        // 查询玄幻小说排行
        Novel fantasy = novelService.getTypeNovelByTopOne("玄幻");
        model.addAttribute("fantasy", fantasy);
        List<Novel> fantasyByTwoToThirteen = novelService.getTypeNovelsByTwoToThirteen("玄幻");
        model.addAttribute("fantasyByTwoToThirteen", fantasyByTwoToThirteen);

        // 查询仙侠小说排行
        Novel xianxia = novelService.getTypeNovelByTopOne("仙侠");
        model.addAttribute("xianxia", xianxia);
        List<Novel> xianxiaByTwoToThirteen = novelService.getTypeNovelsByTwoToThirteen("仙侠");
        model.addAttribute("xianxiaByTwoToThirteen", xianxiaByTwoToThirteen);

        // 查询都市小说排行
        Novel city = novelService.getTypeNovelByTopOne("都市");
        model.addAttribute("city", city);
        List<Novel> cityByTwoToThirteen = novelService.getTypeNovelsByTwoToThirteen("都市");
        model.addAttribute("cityByTwoToThirteen", cityByTwoToThirteen);

        // 查询历史小说排行
        Novel history = novelService.getTypeNovelByTopOne("历史");
        model.addAttribute("history", history);
        List<Novel> historyByTwoToThirteen = novelService.getTypeNovelsByTwoToThirteen("历史");
        model.addAttribute("historyByTwoToThirteen", historyByTwoToThirteen);

        // 查询网游小说排行
        Novel onlinegame = novelService.getTypeNovelByTopOne("网游");
        model.addAttribute("onlinegame", onlinegame);
        List<Novel> onlinegameByTwoToThirteen = novelService.getTypeNovelsByTwoToThirteen("网游");
        model.addAttribute("onlinegameByTwoToThirteen", onlinegameByTwoToThirteen);

        // 查询科幻小说排行
        Novel sciencefiction = novelService.getTypeNovelByTopOne("科幻");
        model.addAttribute("sciencefiction", sciencefiction);
        List<Novel> sciencefictionByTwoToThirteen = novelService.getTypeNovelsByTwoToThirteen("科幻");
        model.addAttribute("sciencefictionByTwoToThirteen", sciencefictionByTwoToThirteen);

        // 查询恐怖小说排行
        Novel terrorist = novelService.getTypeNovelByTopOne("恐怖");
        model.addAttribute("terrorist", terrorist);
        List<Novel> terroristByTwoToThirteen = novelService.getTypeNovelsByTwoToThirteen("恐怖");
        model.addAttribute("terroristByTwoToThirteen", terroristByTwoToThirteen);

        // 查询言情小说排行
        Novel romance = novelService.getTypeNovelByTopOne("言情");
        model.addAttribute("romance", romance);
        List<Novel> romanceByTwoToThirteen = novelService.getTypeNovelsByTwoToThirteen("言情");
        model.addAttribute("romanceByTwoToThirteen", romanceByTwoToThirteen);

        // 查询其他小说排行
        Novel other = novelService.getTypeNovelByTopOne("其他");
        model.addAttribute("other", other);
        List<Novel> otherByTwoToThirteen = novelService.getTypeNovelsByTwoToThirteen("其他");
        model.addAttribute("otherByTwoToThirteen", otherByTwoToThirteen);

        // 查询最新小说
        List<Novel> novelsByNew = novelService.getNovelsByNew();
        model.addAttribute("novelsByNew", novelsByNew);

        // 查询最新更新小说
        List<Novel> novelsByNewUpdate = novelService.getNovelsByNewUpdate();
        model.addAttribute("novelsByNewUpdate", novelsByNewUpdate);
        Map<Integer, String> map = new HashMap<>();
        for (Novel novel : novelsByNewUpdate) {
            map.put(novel.getNovelId(), DateUtil.date2String(novel.getUpdateTime()));
        }

        // 查询所有小说最新章节的章节id
        Map<Integer, Integer> allNovelsNewUpdateChapterId = getAllNovelsNewUpdateChapterId();

        model.addAttribute("map", map).addAttribute("allNovelsNewUpdateChapterId", allNovelsNewUpdateChapterId);

        return "main";
    }

    /**
     * 查询所有小说最新章节的章节id
     *
     * @return
     */
    private Map<Integer, Integer> getAllNovelsNewUpdateChapterId() {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Novel> novels = novelService.getNovels();
        for (Novel novel : novels) {
            map.put(novel.getNovelId(), chapterService.getNewUpdateChapterIdByNovelId(novel.getNovelId()));
        }
        return map;
    }

    /**
     * 显示分类页面小说的信息
     *
     * @param type  小说类型
     * @param model 存储查询的小说信息
     * @return 跳转页面
     */
    @GetMapping("/category")
    public String getCategoryNovels(@RequestParam(value = "type") String type, Model model, HttpServletRequest request,
                                    @RequestParam(value = "tag_id", defaultValue = "0") Integer tagId,
                                    @RequestParam(value = "words", defaultValue = "0") Integer words,
                                    @RequestParam(value = "is_complete", defaultValue = "0") Integer is_complete,
                                    @RequestParam(value = "is_reverse", defaultValue = "0") Integer is_reverse) {
        Map<Integer, String> map = new HashMap<>();
        HashMap<String, String> addClass = new HashMap<>();

        // 查询标签
        List<Tag> tags = tagService.getTags();

        // 查询所有小说最新章节的章节id
        Map<Integer, Integer> allNovelsNewUpdateChapterId = getAllNovelsNewUpdateChapterId();

        // 将小说类型存好，并转发至相应页面
        model.addAttribute("type", type).addAttribute("tag_id", tagId).addAttribute("words", words)
                .addAttribute("is_complete", is_complete).addAttribute("is_reverse", is_reverse)
                .addAttribute("allNovelsNewUpdateChapterId", allNovelsNewUpdateChapterId);

        // 判定小说类型，进行分类
        if ("fantasy".equals(type)) {
            type = "玄幻";
        } else if ("xianxia".equals(type)) {
            type = "仙侠";
        } else if ("city".equals(type)) {
            type = "都市";
        } else if ("history".equals(type)) {
            type = "历史";
        } else if ("onlinegame".equals(type)) {
            type = "网游";
        } else if ("sciencefiction".equals(type)) {
            type = "科幻";
        } else if ("terrorist".equals(type)) {
            type = "恐怖";
        } else if ("romance".equals(type)) {
            type = "言情";
        } else if ("other".equals(type)) {
            type = "其他";
        } else if ("complete".equals(type)) {
            // 跳转至完本小说页面
            addClass.put(type, "backgroundcolor");
            List<Novel> completeNovels = getCategoryNovel(tagId, null, words, 2, is_reverse, tags);

            for (Novel novel : completeNovels) {
                map.put(novel.getNovelId(), DateUtil.date2String(novel.getUpdateTime()));
            }
            model.addAttribute("UpdateTimes", map).addAttribute("categoryNovels", completeNovels).addAttribute("addClass", addClass).addAttribute("tags", tags);
            return "categoryNovel";
        } else if ("rank".equals(type)) {
            // 跳转至排行小说页面
            List<Novel> novelsByViewsTop = novelService.getNovelsByViews(3);
            List<Novel> novelList = novelService.getNovelsByViews(50);
            for (Novel novel : novelList) {
                map.put(novel.getNovelId(), DateUtil.date2String(novel.getUpdateTime()));
            }
            model.addAttribute("novelsByViewsTop", novelsByViewsTop).addAttribute("novelList", novelList).addAttribute("UpdateTimes", map);
            return "rank";
        } else if ("library".equals(type)) {
            // 跳转至书库页面
            List<Novel> novels = getCategoryNovel(tagId, null, words, is_complete, is_reverse, tags);
            for (Novel novel : novels) {
                map.put(novel.getNovelId(), DateUtil.date2String(novel.getUpdateTime()));
            }
            model.addAttribute("categoryNovels", novels).addAttribute("UpdateTimes", map).addAttribute("tags", tags);
            return "categoryNovel";
        }

        // 获取相应类型的小说
        List<Novel> categoryNovels = getCategoryNovel(tagId, type, words, is_complete, is_reverse, tags);

        // 判定小说类型，获取相应类型的小说信息
        addClass.put(type, "backgroundcolor");

        for (Novel novel : categoryNovels) {
            map.put(novel.getNovelId(), DateUtil.date2String(novel.getUpdateTime()));
        }
        model.addAttribute("UpdateTimes", map).addAttribute("categoryNovels", categoryNovels)
                .addAttribute("addClass", addClass).addAttribute("tags", tags);

        return "categoryNovel";
    }

    /**
     * 根据条件获取相应类型的小说信息
     *
     * @param tagId       标签id
     * @param type        小说类型
     * @param words       小说字数
     * @param is_complete 是否完本
     * @param is_reverse  是否倒序
     * @param tags        所有的标签
     * @return
     */
    private List<Novel> getCategoryNovel(Integer tagId, String type, Integer words, Integer is_complete, Integer is_reverse, List<Tag> tags) {
        List<Novel> categoryNovels = null;
        if (type == null) {
            if (tagId == 0) {
                categoryNovels = novelService.getNovelsByTag(is_complete, null, words, is_reverse);
            } else {
                for (Tag tag : tags) {
                    if (tag.getTagId().equals(tagId)) {
                        categoryNovels = novelService.getNovelsByTag(is_complete, tag.getTagName(), words, is_reverse);
                        break;
                    }
                }
            }
        } else {
            if (tagId == 0) {
                categoryNovels = novelService.getTypeNovelsByConditions(type, null, words, is_complete, is_reverse);
            } else {
                for (Tag tag : tags) {
                    if (tag.getTagId().equals(tagId)) {
                        categoryNovels = novelService.getTypeNovelsByConditions(type, tag.getTagName(), words, is_complete, is_reverse);
                        break;
                    }
                }
            }
        }
        return categoryNovels;
    }

    /**
     * 通过搜索框输入条件字段搜索小说
     *
     * @param condition 条件字段
     * @param model     返回信息
     * @return
     */
    @PostMapping("/search")
    public String searchNovels(String condition, Model model) {
        List<Novel> list = novelService.getNovels();
        // 查询所有小说最新章节的章节id
        Map<Integer, Integer> allNovelsNewUpdateChapterId = getAllNovelsNewUpdateChapterId();
        if (condition != null) {
            String field = "%" + condition + "%";
            List<Novel> novels = novelService.searchNovelsByField(field);
            model.addAttribute("searchNovels", novels).addAttribute("condition", condition)
                    .addAttribute("maxSize", list.size()).addAttribute("allNovelsNewUpdateChapterId", allNovelsNewUpdateChapterId);
            return "search";
        }
        return "redirect:/list";
    }

    /**
     * 传入小说信息，返回小说的类型
     *
     * @param novel
     * @return
     */
    private String getType(Novel novel) {
        if (novel != null) {
            String type = novel.getType();
            if ("玄幻".equals(type)) {
                type = "fantasy";
            } else if ("仙侠".equals(type)) {
                type = "xianxia";
            } else if ("都市".equals(type)) {
                type = "city";
            } else if ("历史".equals(type)) {
                type = "history";
            } else if ("网游".equals(type)) {
                type = "onlinegame";
            } else if ("科幻".equals(type)) {
                type = "sciencefiction";
            } else if ("恐怖".equals(type)) {
                type = "terrorist";
            } else if ("言情".equals(type)) {
                type = "romance";
            } else if ("其他".equals(type)) {
                type = "other";
            } else {
                type = "...";
            }
            return type;
        } else {
            return null;
        }
    }

    /**
     * 根据小说id查出小说章节，跳转该小说章节目录页面
     *
     * @param novelId
     * @param model
     * @return
     */
    @GetMapping("/chapter")
    public String toChapterPage(Integer novelId, Model model) {
        Novel novel = novelService.getNovelByNovelId(novelId);
        String type = getType(novel);
        String novel_update_time = DateUtil.date2String(novel.getUpdateTime());
        List<Chapter> chapters = chapterService.getChaptersByNovelId(novelId);
        Integer newUpdateChapterId = chapterService.getNewUpdateChapterIdByNovelId(novelId);
        model.addAttribute("novel", novel).addAttribute("chapters", chapters).addAttribute("type", type).
                addAttribute("novel_update_time", novel_update_time).addAttribute("newUpdateChapterId", newUpdateChapterId);
        return "chapter";
    }

    /**
     * 通过该方法查询每个章节的详细内容，并显示在观看页面
     *
     * @param chapterId 章节id
     * @param model
     * @return
     */
    @GetMapping("/detail")
    public String toDetailPage(Integer chapterId, Model model, HttpSession session) {
        Detail detail = detailService.getChapterDetailByChapterId(chapterId);
        if (detail == null) {
            model.addAttribute("detail",null);
        } else {
            Novel novel = novelService.getNovelByNovelId(detail.getNovelId());
            String type = getType(novel);
            addNovelHistory(session, novel, chapterId);
            updateBookcase(session, novel, chapterId);

            model.addAttribute("detail", detail).addAttribute("novel", novel).addAttribute("type", type);
        }
        return "detail";
    }

    private void addNovelHistory(HttpSession session, Novel novel, Integer chapterId) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            History history = new History(null, user.getUserId(), novel.getNovelId(), chapterId, new Date(), novel.getStatus());
            historyService.addNovelHistory(history, user.getUserId());
        }
    }

    private void updateBookcase(HttpSession session, Novel novel, Integer chapterId) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Bookcase bookcase = new Bookcase(null, novel.getNovelId(), user.getUserId(), novel.getStatus(), chapterId);
            bookcaseService.updateBookcase(bookcase, user.getUserId());
        }
    }

    @GetMapping("/turnPage")
    public String upOrDownChapter(Integer chapterId, Integer novelId, Integer turn, HttpSession session) {
        if (turn == 0 || turn == 1) {
            Novel novel = novelService.getNovelByNovelId(novelId);
            Integer newChapterId = detailService.getNewChapterIdByNovelIdAndChapterIdAndTurn(chapterId, novelId, turn);
            if (newChapterId != null) {
                addNovelHistory(session, novel, newChapterId);
                updateBookcase(session, novel, newChapterId);
                return "redirect:/detail?chapterId=" + newChapterId;
            } else {
                addNovelHistory(session, novel, newChapterId);
                updateBookcase(session, novel, newChapterId);
                return "redirect:/chapter?novelId=" + novelId;
            }
        } else {
            return "redirect:/chapter?novelId=" + novelId;
        }
    }

    @GetMapping("/addBookcase")
    @ResponseBody
    public String addBookcase(Integer novelId, @RequestParam(value = "chapterId", defaultValue = "0") Integer chapterId,
                              HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null && novelId != null) {
            List<Bookcase> bookcases = bookcaseService.getBookcasesByUserId(user.getUserId());
            for (Bookcase bookcase : bookcases) {
                if (bookcase.getNovelId().equals(novelId)) {
                    return "error";
                }
            }
            Novel novel = novelService.getNovelByNovelId(novelId);
            Bookcase bookcase = new Bookcase(null, novelId, user.getUserId(), novel.getStatus(), chapterId);
            Integer i = bookcaseService.addBookcase(bookcase);
            if (i != null) {
                return "success";
            } else {
                return "false";
            }
        } else {
            return null;
        }
    }

}
