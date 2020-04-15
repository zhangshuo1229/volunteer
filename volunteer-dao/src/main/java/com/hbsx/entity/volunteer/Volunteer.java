package com.hbsx.entity.volunteer;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/27 9:37
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：志愿者
 */
@TableName("mx_volunteer")
@Data
public class Volunteer implements Serializable {
    private static final long serialVersionUID = -1973589299985389953L;
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
     * 支援者名字
     */
    private  String volunteerName;
    /**
     * 性别
     */
    private  Integer sex;
    /**
     * 生日
     */
    private Date birthDate;
    /**
     * 身份证
     */
    private  String identityCard;
    /**
     * 职业
     */
    private  String occupation;
    /**
     * 学历
     */
    private  String education;
    /**
     * 注册时间
     */
    private Date registerDate;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除（0表示已删除，1表示未删除）
     */
    private String isValid;
    /**
     * 志愿者id
     */
    private String volunteerId;

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

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }
}
