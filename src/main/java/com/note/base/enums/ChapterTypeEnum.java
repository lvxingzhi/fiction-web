package com.note.base.enums;

import com.note.base.utils.ObjectUtil;

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
 * @date 2017/3/21
 * @since 1.0
 */
public enum ChapterTypeEnum {

    NORMAL(1,"普通章节"),
    VIP(2,"VIP章节");

    private int type;
    private String desc;

    ChapterTypeEnum(int type,String desc){
        this.type=type;
        this.desc=desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static ChapterTypeEnum getByType(int type){
        if(ObjectUtil.isNull(type)){
            return null;
        }
        for (ChapterTypeEnum chapterTypeEnum : ChapterTypeEnum.values()) {
            if (chapterTypeEnum.getType() == type) {
                return chapterTypeEnum;
            }
        }
        return null;
    }
}
