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
 * @date 2017/2/28
 * @since 1.0
 */
public enum FictionRankTypeEnum {

    VIEW(1,"浏览量"),
    SCORE(2,"分数");

    private int type;
    private String desc;

    FictionRankTypeEnum(int type,String desc){
        this.type=type;
        this.desc=desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static FictionRankTypeEnum getByType(int type){
        if(ObjectUtil.isNull(type)){
            return null;
        }
        for (FictionRankTypeEnum fictionRankTypeEnum : FictionRankTypeEnum.values()) {
            if (fictionRankTypeEnum.getType() == type) {
                return fictionRankTypeEnum;
            }
        }
        return null;
    }
}
