package com.kh.reactbackend.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageResponse<T> {
    private List<T> content;
    private int currentPage;
    private int totalPage;
    private long totalCount;
    private boolean hasNext;
    private boolean hasPrevious;

    public PageResponse(Page<T> page){
        this.content = page.getContent();
        this.currentPage = page.getNumber();
        this.totalPage = page.getTotalPages();
        this.hasNext = page.hasNext();
        this.hasPrevious = page.hasPrevious();
        this.totalCount = page.getTotalElements();
    }
}
