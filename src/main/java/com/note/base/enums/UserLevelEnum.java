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
public enum UserLevelEnum {

    NORMAL(1,"普通"),
    VIP(2,"VIP");

    private Integer type;
    private String desc;

    UserLevelEnum(Integer type, String desc){
        this.type=type;
        this.desc=desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static UserLevelEnum getByType(Integer type){
        if(ObjectUtil.isNull(type)){
            return null;
        }
        for (UserLevelEnum userLevelEnum : UserLevelEnum.values()) {
            if (userLevelEnum.getType().equals(type)) {
                return userLevelEnum;
            }
        }
        return null;
    }

}
