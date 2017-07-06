package com.note.fiction.dto.response;

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
public class FictionRankSearchResp {

    private String fictionCode;

    private String fictionName;

    private Double fictionScore;

    private Integer fictionViews;

    private String authorName;

    private String typeName;

    public String getFictionCode() {
        return fictionCode;
    }

    public void setFictionCode(String fictionCode) {
        this.fictionCode = fictionCode;
    }

    public String getFictionName() {
        return fictionName;
    }

    public void setFictionName(String fictionName) {
        this.fictionName = fictionName;
    }

    public Double getFictionScore() {
        return fictionScore;
    }

    public void setFictionScore(Double fictionScore) {
        this.fictionScore = fictionScore;
    }

    public Integer getFictionViews() {
        return fictionViews;
    }

    public void setFictionViews(Integer fictionViews) {
        this.fictionViews = fictionViews;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
