package com.lee.mapper;

import com.lee.entity.History;
import com.lee.entity.HistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryMapper {
    long countByExample(HistoryExample example);

    int deleteByExample(HistoryExample example);

    int deleteByPrimaryKey(Integer historyId);

    int deleteByNovelId(Integer novelId);

    int insert(History record);

    int insertSelective(History record);

    List<History> selectByExample(HistoryExample example);

    List<History> selectHistoriesByUserId(Integer userId);

    History selectByPrimaryKey(Integer historyId);

    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
}