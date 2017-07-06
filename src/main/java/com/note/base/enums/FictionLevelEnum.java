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
public enum FictionLevelEnum {

    OUTSIDE_NORMAL("OUTSIDE_NORMAL","网络作品"),
    OUTSIDE_VIP("OUTSIDE_VIP","网络VIP"),
    ORIGINAL_NORMAL("ORIGINAL_NORMAL","原创作品"),
    ORIGINAL_VIP("ORIGINAL_VIP","原创VIP");

    private String type;
    private String desc;

    FictionLevelEnum(String type, String desc){
        this.type=type;
        this.desc=desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static FictionLevelEnum getByType(String type){
        if(ObjectUtil.isNull(type)){
            return null;
        }
        for (FictionLevelEnum fictionLevelEnum : FictionLevelEnum.values()) {
            if (fictionLevelEnum.getType().equals(type)) {
                return fictionLevelEnum;
            }
        }
        return null;
    }

}
