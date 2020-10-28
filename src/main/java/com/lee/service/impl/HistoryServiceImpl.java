package com.lee.service.impl;

import com.lee.entity.History;
import com.lee.entity.HistoryExample;
import com.lee.mapper.HistoryMapper;
import com.lee.service.HistoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public Integer addNovelHistory(History history, Integer userId) {
        List<History> novelHistories = getNovelHistoriesByUserId(userId);
        for (History h : novelHistories) {
            if (h.getNovelId().equals(history.getNovelId())) {
                history.setHistoryId(h.getHistoryId());
                return historyMapper.updateByPrimaryKey(history);
            }
        }
        return historyMapper.insert(history);
    }

    @Override
    public List<History> getNovelHistories() {
        return historyMapper.selectByExample(new HistoryExample());
    }

    @Override
    public List<History> getNovelHistoriesByUserId(Integer userId) {
        return historyMapper.selectHistoriesByUserId(userId);
    }

    @Override
    public Integer deleteByNovelId(Integer novelId) {
        return historyMapper.deleteByNovelId(novelId);
    }
}
