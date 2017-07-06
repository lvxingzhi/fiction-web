package com.note.fiction.dto.response;

import java.util.Date;

/**
 * <p>TODO </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/2/28
 * @since 1.0
 */
public class FictionChapterInfoResp {

    private Integer cid;

    private String logicCode;

    private String fictionCode;

    private Integer chapterSort;

    private String chapterName;

    private Integer chapterType;

    private Integer chapterViews;

    private Integer chapterWordCount;

    private Date createTime;

    private Date modifyTime;

    private String createUserCode;

    private String modifyUserCode;

    private String chapterContent;

    /**
     * 上一章节
     */
    private String previousCode;
    /**
     * 下一章节
     */
    private String nextCode;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getLogicCode() {
        return logicCode;
    }

    public void setLogicCode(String logicCode) {
        this.logicCode = logicCode;
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

    public Integer getChapterViews() {
        return chapterViews;
    }

    public void setChapterViews(Integer chapterViews) {
        this.chapterViews = chapterViews;
    }

    public Integer getChapterWordCount() {
        return chapterWordCount;
    }

    public void setChapterWordCount(Integer chapterWordCount) {
        this.chapterWordCount = chapterWordCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public String getModifyUserCode() {
        return modifyUserCode;
    }

    public void setModifyUserCode(String modifyUserCode) {
        this.modifyUserCode = modifyUserCode;
    }

    public String getPreviousCode() {
        return previousCode;
    }

    public void setPreviousCode(String previousCode) {
        this.previousCode = previousCode;
    }

    public String getNextCode() {
        return nextCode;
    }

    public void setNextCode(String nextCode) {
        this.nextCode = nextCode;
    }
}
