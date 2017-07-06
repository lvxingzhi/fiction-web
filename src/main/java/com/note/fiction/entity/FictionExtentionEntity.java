package com.note.fiction.entity;

import java.util.Date;

public class FictionExtentionEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.cid
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.logic_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String logicCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.fiction_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String fictionCode;

    private Double fictionScore;

    private Integer fictionScoreNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.full_desc
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String fullDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.total_chapter
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer totalChapter;

    private Integer totalWord;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.last_update_time
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.level
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.fiction_views
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer fictionViews;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.last_chapter_name
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String lastChapterName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.last_chapter_id
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String lastChapterCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.create_time
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.modify_time
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.create_user_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String createUserCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.modify_user_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String modifyUserCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_extention.is_delete
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer isDelete;

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

    public Double getFictionScore() {
        return fictionScore;
    }

    public void setFictionScore(Double fictionScore) {
        this.fictionScore = fictionScore;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getFictionScoreNum() {
        return fictionScoreNum;
    }

    public void setFictionScoreNum(Integer fictionScoreNum) {
        this.fictionScoreNum = fictionScoreNum;
    }

    public Integer getTotalWord() {
        return totalWord;
    }

    public void setTotalWord(Integer totalWord) {
        this.totalWord = totalWord;
    }
}