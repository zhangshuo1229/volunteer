package com.hbsx.entity.volunteer;

import java.io.Serializable;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/27 9:37
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：志愿者活动
 */
public class HzVolunteerActivity implements Serializable {
    private static final long serialVersionUID = -366377044457102388L;
    /**
     * 主键id
     */
    private  Integer id;
    /**
     * 部门编码
     */
    private  String instCode;
    /**
     * 部门名称
     */
    private  String instName;
    /**
     * 活动数量
     */
    private  Integer activityNum;
    /**
     * 参与人数
     */
    private  Integer participantNum;
    /**
     * 活动类型
     */
    private  String diType;
    /**
     * 时间维度
     */
    private  Integer  diTime;
    /**
     * 日期
     */
    private  String tjDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public Integer getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(Integer activityNum) {
        this.activityNum = activityNum;
    }

    public Integer getParticipantNum() {
        return participantNum;
    }

    public void setParticipantNum(Integer participantNum) {
        this.participantNum = participantNum;
    }

    public String getDiType() {
        return diType;
    }

    public void setDiType(String diType) {
        this.diType = diType;
    }

    public Integer getDiTime() {
        return diTime;
    }

    public void setDiTime(Integer diTime) {
        this.diTime = diTime;
    }

    public String getTjDate() {
        return tjDate;
    }

    public void setTjDate(String tjDate) {
        this.tjDate = tjDate;
    }
}
