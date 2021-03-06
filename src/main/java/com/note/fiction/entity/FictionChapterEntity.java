package com.note.fiction.entity;

import java.util.Date;

public class FictionChapterEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.cid
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.logic_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String logicCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.fiction_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String fictionCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.chapter_sort
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer chapterSort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.chapter_name
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String chapterName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.chapter_type
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer chapterType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.chapter_views
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer chapterViews;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.chapter_word_count
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer chapterWordCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.create_time
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.modify_time
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.create_user_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String createUserCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.modify_user_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String modifyUserCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fiction_chapter.is_delete
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
}