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
 * @description：志愿者团队
 */
@TableName("mx_volunteer_group")
@Data
public class VolunteerGroup implements Serializable {
    private static final long serialVersionUID = -1846500159585366636L;
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
     * 团队名称
     */
    private  String groupName;
    /**
     * 成立日期
     */
    private Date establishDate;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 逻辑删除（0表示已删除，1表示未删除）
     */
    private String isValid;
    /**
     * 团队id
     */
    private  String groupId;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
