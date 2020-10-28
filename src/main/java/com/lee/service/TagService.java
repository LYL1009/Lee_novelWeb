package com.lee.service;

import com.lee.entity.Tag;

import java.util.List;

public interface TagService {

    default List<Tag> getTags() {
        return null;
    }

}
