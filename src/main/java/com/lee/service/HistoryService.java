package com.lee.service;

import com.lee.entity.History;
import com.lee.entity.HistoryExample;

import java.util.List;

public interface HistoryService {

    default Integer addNovelHistory(History history,Integer userId) {
        return null;
    }

    default List<History> getNovelHistories() {
        return null;
    }

    default List<History> getNovelHistoriesByUserId(Integer userId) {
        return null;
    }

    default Integer deleteByNovelId(Integer novelId) {
        return null;
    }

}
