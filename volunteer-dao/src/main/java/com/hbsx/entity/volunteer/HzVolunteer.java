package com.hbsx.entity.volunteer;

import java.io.Serializable;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/27 9:37
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：志愿者
 */
public class HzVolunteer implements Serializable {
    private static final long serialVersionUID = -9018408865525911069L;
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
     * 年龄维度
     */
    private  Integer diAge;
    /**
     * 学历维度
     */
    private  String diEducation;
    /**
     * 职业维度
     */
    private  String diOccupation;
    /**
     * 性别维度
     */
    private  Integer diSex;
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

    public Integer getDiAge() {
        return diAge;
    }

    public void setDiAge(Integer diAge) {
        this.diAge = diAge;
    }

    public String getDiEducation() {
        return diEducation;
    }

    public void setDiEducation(String diEducation) {
        this.diEducation = diEducation;
    }

    public String getDiOccupation() {
        return diOccupation;
    }

    public void setDiOccupation(String diOccupation) {
        this.diOccupation = diOccupation;
    }

    public Integer getDiSex() {
        return diSex;
    }

    public void setDiSex(Integer diSex) {
        this.diSex = diSex;
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
