package com.note.fiction.dto.request;

/**
 * 创建章节
 */
public class FictionChapterAddReq {

    private String fictionCode;

    private Integer chapterSort;

    private String chapterName;

    private Integer chapterType;

    private String chapterContent;

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    public String getFictionCode() {
        return fictionCode;
    }

    public void setFictionCode(String fictionCode) {
        this.fictionCode = fictionCode;
    }

    public Integer getChapterSort() {
        return chapterSort;
    }

    public void setChapterSort(Integer chapterSort) {
        this.chapterSort = chapterSort;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Integer getChapterType() {
        return chapterType;
    }

    public void setChapterType(Integer chapterType) {
        this.chapterType = chapterType;
    }
}
