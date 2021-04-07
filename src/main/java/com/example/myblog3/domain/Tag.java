package com.example.myblog3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Tag {
    private Long tagId;
    private String tagName;
    private List<Blog> blogList;
}
