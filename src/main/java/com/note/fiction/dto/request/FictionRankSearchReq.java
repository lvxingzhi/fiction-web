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
public class FictionRankSearchReq extends PageDto {

    /**
     * 排名类型
     * @see com.note.base.enums.FictionRankTypeEnum
     */
    private Integer rankType;

    public Integer getRankType() {
        return rankType;
    }

    public void setRankType(Integer rankType) {
        this.rankType = rankType;
    }
}
