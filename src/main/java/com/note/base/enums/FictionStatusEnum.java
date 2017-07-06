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
public enum FictionStatusEnum {
    ING(1,"更新中"),
    END(2,"已完结"),
    EUNUCH(2,"太监");

    private int type;
    private String desc;

    FictionStatusEnum(int type,String desc){
        this.type=type;
        this.desc=desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static FictionStatusEnum getByType(int type){
        if(ObjectUtil.isNull(type)){
            return null;
        }
        for (FictionStatusEnum fictionStatusEnum : FictionStatusEnum.values()) {
            if (fictionStatusEnum.getType() == type) {
                return fictionStatusEnum;
            }
        }
        return null;
    }

}
