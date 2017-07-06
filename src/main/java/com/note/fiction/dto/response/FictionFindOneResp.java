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
public class FictionFindOneResp {

    /**
     * logicCode
     */
    private String logicCode;
    /**
     * 标题
     */
    private String title;
    /**
     * 简单描述
     */
    private String shortDesc;
    /**
     * 封面
     */
    private String coverPhoto;
    /**
     * 状态
     */
    private Integer fictionStatus;
    /**
     * 类型CODE
     */
    private String typeCode;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 作者CODE
     */
    private String authorCode;
    /**
     * 作者名称
     */
    private String authorName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者CODE
     */
    private String createUserCode;


    /**
     * 详细描述
     */
    private String fullDesc;
    /**
     * 章节总数
     */
    private Integer totalChapter;

    private Integer totalWord;
    /**
     * 最近更新时间
     */
    private Date lastUpdateTime;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 浏览量
     */
    private Integer fictionViews;

    private Double fictionScore;

    private Integer fictionScoreNum;
    /**
     * 最近更新章节名称
     */
    private String lastChapterName;
    /**
     * 最近更新章节CODE
     */
    private String lastChapterCode;

    public String getLogicCode() {
        return logicCode;
    }

    public void setLogicCode(String logicCode) {
        this.logicCode = logicCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(String authorCode) {
        this.authorCode = authorCode;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    public Integer getTotalChapter() {
        return totalChapter;
    }

    public void setTotalChapter(Integer totalChapter) {
        this.totalChapter = totalChapter;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getFictionViews() {
        return fictionViews;
    }

    public void setFictionViews(Integer fictionViews) {
        this.fictionViews = fictionViews;
    }

    public String getLastChapterName() {
        return lastChapterName;
    }

    public void setLastChapterName(String lastChapterName) {
        this.lastChapterName = lastChapterName;
    }

    public String getLastChapterCode() {
        return lastChapterCode;
    }

    public void setLastChapterCode(String lastChapterCode) {
        this.lastChapterCode = lastChapterCode;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public Integer getFictionStatus() {
        return fictionStatus;
    }

    public void setFictionStatus(Integer fictionStatus) {
        this.fictionStatus = fictionStatus;
    }

    public Double getFictionScore() {
        return fictionScore;
    }

    public void setFictionScore(Double fictionScore) {
        this.fictionScore = fictionScore;
    }

    public Integer getTotalWord() {
        return totalWord;
    }

    public void setTotalWord(Integer totalWord) {
        this.totalWord = totalWord;
    }

    public Integer getFictionScoreNum() {
        return fictionScoreNum;
    }

    public void setFictionScoreNum(Integer fictionScoreNum) {
        this.fictionScoreNum = fictionScoreNum;
    }
}
