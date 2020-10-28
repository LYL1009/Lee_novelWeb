package com.lee.controller;

import com.lee.entity.*;
import com.lee.service.*;
import com.lee.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private NovelService novelService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private BookcaseService bookcaseService;

    @Autowired
    private AuthorService authorService;

    @PostMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
        List<User> users = userService.getUsers();
        if (username != null && password != null) {
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    session.setAttribute("user", user);
                    Author author = authorService.getAuthorByUserId(user.getUserId());
                    session.setAttribute("author", author);
                    return "success";
                }
            }
        }
        return "error";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(String username, String email, String password, String phone) {
        if (username != null && email != null && password != null && phone != null) {
            List<User> users = userService.getUsers();
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return "username";
                } else if (user.getEmail().equals(email)) {
                    return "email";
                } else if (user.getPhone().equals(phone)) {
                    return "phone";
                }
            }
            User user = new User(null, username, password, null, email, null, phone, null, null);
            Integer i = userService.addUser(user);
            if (i != null) {
                return "success";
            }
        }
        return null;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/list";
    }

    @GetMapping("/user/recentlyRead")
    public String recentlyRead(Model model, HttpSession session) {
        // 用历史记录id-对应存放的小说
        HashMap<Integer, Novel> map = new HashMap<>();
        // 用历史记录id-对应阅读记录（上次阅读到的章数）
        HashMap<Integer, String> readSchedule = new HashMap<>();
        // 用历史记录id-对应上次阅读时间
        HashMap<Integer, String> lastReadTimes = new HashMap<>();

        User user = (User) session.getAttribute("user");
        List<History> novelHistories = historyService.getNovelHistoriesByUserId(user.getUserId());

        for (History history : novelHistories) {
            map.put(history.getHistoryId(), novelService.getNovelByNovelId(history.getNovelId()));
            readSchedule.put(history.getHistoryId(), chapterService.getChapterByChapterId(history.getChapterId()).getChapterName());
            lastReadTimes.put(history.getHistoryId(), DateUtil.date2String(history.getLastReadTime()));
        }

        Map<Integer, Integer> allNovelsNewUpdateChapterId = getAllNovelsNewUpdateChapterId();

        model.addAttribute("novelHistories", novelHistories).addAttribute("map", map).addAttribute("readSchedule", readSchedule)
                .addAttribute("lastReadTimes", lastReadTimes).addAttribute("allNovelsNewUpdateChapterId", allNovelsNewUpdateChapterId);
        return "user/recentlyRead";
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
     * 查询所有小说第一章的章节id
     *
     * @return
     */
    private Map<Integer, Integer> getAllNovelsFirstChapterId() {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Novel> novels = novelService.getNovels();
        for (Novel novel : novels) {
            map.put(novel.getNovelId(), chapterService.getFirstChapterIdByNovelId(novel.getNovelId()));
        }
        return map;
    }

    @GetMapping("/user/myBookcase")
    public String toMyBookcasePage(Model model, HttpSession session) {
        // 用书架id-对应存放的小说
        HashMap<Integer, Novel> map = new HashMap<>();
        // 用书架id-对应阅读记录（上次阅读到的章数）
        HashMap<Integer, String> readSchedule = new HashMap<>();
        // 用书架id-对应最新更新时间
        HashMap<Integer, String> updateTimes = new HashMap<>();

        User user = (User) session.getAttribute("user");
        List<Bookcase> bookcases = bookcaseService.getBookcasesByUserId(user.getUserId());
        for (Bookcase bookcase : bookcases) {
            Novel novel = novelService.getNovelByNovelId(bookcase.getNovelId());
            map.put(bookcase.getBookcaseId(), novel);
            if (bookcase.getChapterId() != 0) {
                readSchedule.put(bookcase.getBookcaseId(), chapterService.getChapterByChapterId(bookcase.getChapterId()).getChapterName());
            } else {
                readSchedule.put(bookcase.getBookcaseId(), "尚未阅读");
            }
            updateTimes.put(bookcase.getBookcaseId(), DateUtil.date2String(novel.getUpdateTime()));
        }

        // 查询所有小说最新章节的章节id
        Map<Integer, Integer> allNovelsNewUpdateChapterId = getAllNovelsNewUpdateChapterId();
        // 查询所有小说第一章的章节id
        Map<Integer, Integer> allNovelsFirstChapterId = getAllNovelsFirstChapterId();

        model.addAttribute("bookcases", bookcases).addAttribute("map", map).addAttribute("readSchedule", readSchedule)
                .addAttribute("updateTimes", updateTimes).addAttribute("allNovelsNewUpdateChapterId", allNovelsNewUpdateChapterId)
                .addAttribute("allNovelsFirstChapterId", allNovelsFirstChapterId);

        return "user/myBookcase";
    }

    @GetMapping("/user/deleteBookcaseRecord")
    public String deleteBookcaseRecord(Integer bookcaseId, HttpSession session) {
        if (session.getAttribute("user") != null) {
            bookcaseService.removeBookcaseRecord(bookcaseId);
        }
        return "redirect:/user/myBookcase";
    }

    @GetMapping("/user/saveUserInfo")
    @ResponseBody
    public String saveUserInfo(Integer id, String gender, String email, String qq, String phone, String userInfo) {
        if (id != null && gender != null && email != null && qq != null && phone != null && userInfo != null) {
            Integer i = null;
            if ("男".equals(gender)) {
                i = 1;
            } else if ("女".equals(gender)) {
                i = 0;
            }
            User user = new User(id, i, email, qq, phone, userInfo);
            userService.updateUserByUserIdSelective(user);
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/user/updateUser")
    public String updateUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<User> users = userService.getUsers();
        for (User u : users) {
            if (u.getUserId().equals(user.getUserId())) {
                session.setAttribute("user", u);
                return "user/userInfo";
            }
        }
        return "redirect:/user/info";
    }

    @PostMapping("/user/becomeAuthor")
    @ResponseBody
    public String becomeAuthor(String authorName, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Integer i = authorService.becomeAuthor(new Author(null, authorName, user.getUserId()));
            if (i != null && i != 0) {
                return "success";
            } else if (i == 0) {
                return "repeat";
            } else {
                return "error";
            }
        }
        return "error";
    }

    @GetMapping("/user/homepage")
    public String toHomePage(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Author author = authorService.getAuthorByUserId(user.getUserId());
            if (author != null) {
                session.setAttribute("author", author);
            }
            return "user/homepage";
        }
        return "redirect:/list";
    }

}
