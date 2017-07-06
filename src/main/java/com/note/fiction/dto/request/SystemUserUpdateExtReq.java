package com.note.fiction.dto.request;

/**
 * Created by Administrator on 2017/3/18.
 */
public class SystemUserUpdateExtReq {

    private String loginName;

    private Integer changeLevel;

    private Integer changeScore;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getChangeLevel() {
        return changeLevel;
    }

    public void setChangeLevel(Integer changeLevel) {
        this.changeLevel = changeLevel;
    }

    public Integer getChangeScore() {
        return changeScore;
    }

    public void setChangeScore(Integer changeScore) {
        this.changeScore = changeScore;
    }
}
