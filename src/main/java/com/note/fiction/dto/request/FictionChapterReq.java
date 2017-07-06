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
public class FictionChapterReq extends PageDto {

    private String fictionCode;

    public String getFictionCode() {
        return fictionCode;
    }

    public void setFictionCode(String fictionCode) {
        this.fictionCode = fictionCode;
    }
}
