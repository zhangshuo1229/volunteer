package com.hbsx.entity.volunteer;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/27 9:37
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：志愿者活动
 */
@TableName("mx_volunteer_activity")
@Data
public class VolunteerActivity implements Serializable {
    private static final long serialVersionUID = 5505331277191554521L;
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
     * 活动名称
     */
    private  String actName;
    /**
     * 参与人数
     */
    private Integer participantNum;

    /**
     * 活动图片
     */
    private  String act_img;
    /**
     * 活动类型
     */
    private  String act_type;
    /**
     * 活动开始时间
     */
    private Date act_start_date;
    /**
     * 活动结束时间
     */
    private Date act_end_date;
    /**
     * 详细活动地点
     */
    private  String address;
    /**
     * 活动介绍
     */
    private  String  content;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 逻辑删除（0表示已删除，1表示未删除）
     */
    private String isValid;
    /**
     * 志愿者id
     */
    private String activityId;

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

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public Integer getParticipantNum() {
        return participantNum;
    }

    public void setParticipantNum(Integer participantNum) {
        this.participantNum = participantNum;
    }

    public String getAct_img() {
        return act_img;
    }

    public void setAct_img(String act_img) {
        this.act_img = act_img;
    }

    public String getAct_type() {
        return act_type;
    }

    public void setAct_type(String act_type) {
        this.act_type = act_type;
    }

    public Date getAct_start_date() {
        return act_start_date;
    }

    public void setAct_start_date(Date act_start_date) {
        this.act_start_date = act_start_date;
    }

    public Date getAct_end_date() {
        return act_end_date;
    }

    public void setAct_end_date(Date act_end_date) {
        this.act_end_date = act_end_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
}
