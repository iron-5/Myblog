package com.example.myblog3;

import com.example.myblog3.domain.Tag;
import com.example.myblog3.domain.Type;
import com.example.myblog3.domain.User;
import com.example.myblog3.service.TagService;
import com.example.myblog3.service.TypeService;
import com.example.myblog3.service.UserService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Myblog3ApplicationTests {

    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Test
    void contextLoads() {
//        Type type = new Type();
//        type.setTypeName("bug");
//        type.setTypeId(Long.valueOf(4));
//        int result1 = typeService.deleteType(type);
//
//        Tag tag = new Tag();
//        tag.setTagName("Spring");
//        tag.setTagId(Long.valueOf(1));
//        int result2 = tagService.deleteTag(tag);
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(1);
        pageRequest.setPageSize(2);
        PageResult types = typeService.findTypeByPage(pageRequest);
//        分页查找tag
//        PageRequest pageRequest = new PageRequest();
//        pageRequest.setPageNum(1);
//        pageRequest.setPageSize(2);
//        PageResult types = tagService.findTagByPage(pageRequest);
//        更新type和tag
//        Type type = new Type();
//        type.setTypeName("bug日记");

//        Type type1 = typeService.findTypeByName("bug");
//        type1.setTypeName("bug日记");
//        typeService.updateType(type1);

//        Tag tag = new Tag();
//        tag.setTagName("SpringBoot");
//        tagService.addTag(tag);
//        Tag tag1 = tagService.findTagByName("SpringMVC");
//        tag1.setTagName("java");
//        tagService.updateTag(tag1);
        System.out.println(types.getContent());
    }

}
