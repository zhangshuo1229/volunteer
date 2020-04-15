package com.hbsx.entity.volunteer;

import java.io.Serializable;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/27 9:37
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：志愿者团队
 */
public class HzVolunteerGroup implements Serializable {
    private static final long serialVersionUID = 6819760914867812340L;
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
     * 志愿者数量
     */
    private  Integer volunteerNum;
    /**
     * 团队数量
     */
    private  Integer groupNum;
    /**
     * 志愿者累计数量
     */
    private  Integer volunteerTotalNum;
    /**
     * 志愿者团队累计数量
     */
    private  Integer groupTotalNum;
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

    public Integer getVolunteerNum() {
        return volunteerNum;
    }

    public void setVolunteerNum(Integer volunteerNum) {
        this.volunteerNum = volunteerNum;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getVolunteerTotalNum() {
        return volunteerTotalNum;
    }

    public void setVolunteerTotalNum(Integer volunteerTotalNum) {
        this.volunteerTotalNum = volunteerTotalNum;
    }

    public Integer getGroupTotalNum() {
        return groupTotalNum;
    }

    public void setGroupTotalNum(Integer groupTotalNum) {
        this.groupTotalNum = groupTotalNum;
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
