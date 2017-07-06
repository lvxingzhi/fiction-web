package com.note.fiction.entity;

import java.util.Date;

public class AccessLogEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column access_log.cid
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    private Long cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column access_log.access_url
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    private String accessUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column access_log.access_ip
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    private String accessIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column access_log.access_time
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    private Date accessTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column access_log.user_code
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    private String userCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column access_log.cid
     *
     * @return the value of access_log.cid
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public Long getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column access_log.cid
     *
     * @param cid the value for access_log.cid
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column access_log.access_url
     *
     * @return the value of access_log.access_url
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public String getAccessUrl() {
        return accessUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column access_log.access_url
     *
     * @param accessUrl the value for access_log.access_url
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl == null ? null : accessUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column access_log.access_ip
     *
     * @return the value of access_log.access_ip
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public String getAccessIp() {
        return accessIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column access_log.access_ip
     *
     * @param accessIp the value for access_log.access_ip
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp == null ? null : accessIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column access_log.access_time
     *
     * @return the value of access_log.access_time
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public Date getAccessTime() {
        return accessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column access_log.access_time
     *
     * @param accessTime the value for access_log.access_time
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column access_log.user_code
     *
     * @return the value of access_log.user_code
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column access_log.user_code
     *
     * @param userCode the value for access_log.user_code
     *
     * @mbg.generated Thu Jul 06 16:22:07 CST 2017
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }
}