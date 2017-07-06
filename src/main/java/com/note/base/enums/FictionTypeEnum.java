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
public enum FictionTypeEnum {

    XUANHUAN("1","玄幻"),
    QIHUAN("2","奇幻"),
    WUXIA("3","武侠"),
    XIANXIA("4","仙侠"),
    DUSHI("5","都市"),
    ZHICHANG("6","职场"),
    JUNSHI("7","军事"),
    LISHI("8","历史"),
    YOUXI("9","游戏"),
    TIYU("10","体育"),
    KEHUAN("11","科幻"),
    LINGYI("12","灵异"),
    ERCIYUAN("13","二次元");


    private String type;
    private String desc;

    FictionTypeEnum(String type,String desc){
        this.type=type;
        this.desc=desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static FictionTypeEnum getByType(String type){
        if(ObjectUtil.isNull(type)){
            return null;
        }
        for (FictionTypeEnum fictionTypeEnum : FictionTypeEnum.values()) {
            if (fictionTypeEnum.getType().equals(type)) {
                return fictionTypeEnum;
            }
        }
        return null;
    }

}
