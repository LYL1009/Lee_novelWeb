package com.lee.mapper;

import com.lee.entity.Bookcase;
import com.lee.entity.BookcaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookcaseMapper {
    long countByExample(BookcaseExample example);

    int deleteByExample(BookcaseExample example);

    int deleteByPrimaryKey(Integer bookcaseId);

    int deleteByNovelId(Integer novelId);

    int insert(Bookcase record);

    int insertSelective(Bookcase record);

    List<Bookcase> selectByExample(BookcaseExample example);

    List<Bookcase> selectBookcasesByUserId(Integer userId);

    Bookcase selectByPrimaryKey(Integer bookcaseId);

    int updateByExampleSelective(@Param("record") Bookcase record, @Param("example") BookcaseExample example);

    int updateByExample(@Param("record") Bookcase record, @Param("example") BookcaseExample example);

    int updateByPrimaryKeySelective(Bookcase record);

    int updateByPrimaryKey(Bookcase record);
}