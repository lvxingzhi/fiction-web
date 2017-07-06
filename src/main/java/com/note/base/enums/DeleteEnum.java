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
public enum DeleteEnum {

    IS_DELETE(1,"删除"),
    NOT_DELETE(0,"未删除");

    private int type;
    private String desc;

    DeleteEnum(int type,String desc){
        this.type=type;
        this.desc=desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static DeleteEnum getByType(int type){
        if(ObjectUtil.isNull(type)){
            return null;
        }
        for (DeleteEnum deleteEnum : DeleteEnum.values()) {
            if (deleteEnum.getType() == type) {
                return deleteEnum;
            }
        }
        return null;
    }

}
