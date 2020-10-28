package com.lee.service.impl;

import com.lee.entity.Tag;
import com.lee.entity.TagExample;
import com.lee.mapper.TagMapper;
import com.lee.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getTags() {
        return tagMapper.selectByExample(new TagExample());
    }

}
