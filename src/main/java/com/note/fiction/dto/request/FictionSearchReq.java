package com.note.fiction.dto.request;

import com.note.base.dto.PageDto;

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
public class FictionSearchReq extends PageDto {

    /**
     * 标题
     */
    private String title;
    /**
     * 类型CODE
     */
    private String typeCode;
    /**
     * 作者CODE
     */
    private String authorCode;
    /**
     * 作者姓名
     */
    private String authorName;
    /**
     * 排序类型
     */
    private String orderBy;
    /**
     * 排序规则
     */
    private String orderByType;

    private Integer fictionStatus;

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

    public String getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(String authorCode) {
        this.authorCode = authorCode;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }

    public Integer getFictionStatus() {
        return fictionStatus;
    }

    public void setFictionStatus(Integer fictionStatus) {
        this.fictionStatus = fictionStatus;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
