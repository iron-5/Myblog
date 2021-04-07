package com.example.myblog3.util;

import lombok.Data;

import java.util.List;
@Data
public class PageResult {
        /**
         * 分页返回结果
         */

        /**
         * 当前页码
         */
        private int pageNum;
        /**
         * 每页数量
         */
        private int pageSize;
        /**
         * 记录总数
         */
        private long totalSize;
        /**
         * 页码总数
         */
        private int totalPages;
        /**
         * 数据模型
         */
        private List<?> content;
}
