package com.example.myblog3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Type {
    private Long typeId;
    private String typeName;
    private List<Blog> blogList;
}
