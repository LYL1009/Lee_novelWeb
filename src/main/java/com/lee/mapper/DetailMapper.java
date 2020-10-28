package com.lee.mapper;

import com.lee.entity.Detail;
import com.lee.entity.DetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailMapper {
    long countByExample(DetailExample example);

    int deleteByExample(DetailExample example);

    int deleteByPrimaryKey(Integer detailId);

    int deleteByNovelId(Integer novelId);

    int deleteDetailByChapterId(Integer chapterId);

    int insert(Detail record);

    int insertSelective(Detail record);

    List<Detail> selectByExampleWithBLOBs(DetailExample example);

    Detail selectChapterDetailByChapterId(Integer chapterId);

    Integer selectNewChapterIdByNovelIdAndChapterIdAndTurn(@Param("chapterId") Integer chapterId,
                                                           @Param("novelId") Integer novelId,@Param("turn") Integer turn);

    List<Detail> selectByExample(DetailExample example);

    Detail selectByPrimaryKey(Integer detailId);

    int updateByExampleSelective(@Param("record") Detail record, @Param("example") DetailExample example);

    int updateByExampleWithBLOBs(@Param("record") Detail record, @Param("example") DetailExample example);

    int updateByExample(@Param("record") Detail record, @Param("example") DetailExample example);

    int updateByPrimaryKeySelective(Detail record);

    int updateByPrimaryKeyWithBLOBs(Detail record);

    int updateByPrimaryKey(Detail record);
}