package com.hbsx.entity.handleinfo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author mazj
 * @email mazj@hopshine.net
 * @date 2019/11/27
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description 采集日志
 */
@TableName("handle_info")
public class HandleInfo implements Serializable {
    private static final long serialVersionUID = 6168471014787800762L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 加工业务分类
     */
    private String handleType;

    /**
     * 加工阶段序号
     */
    private String handleStage;

    /**
     * 加工阶段名称
     */
    private String handleName;

    /**
     * 加工结束时间
     */
    private LocalDateTime handleTime;

    /**
     * 加工开始时间
     */
    private Date startTime;

    /**
     * 成功失败标志
     */
    private String isSuccess;

    /**
     * 失败异常信息
     */
    private String handleMsg;

    /**
     * 模块类型
     */
    private String moduleType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getHandleStage() {
        return handleStage;
    }

    public void setHandleStage(String handleStage) {
        this.handleStage = handleStage;
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

    public LocalDateTime getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(LocalDateTime handleTime) {
        this.handleTime = handleTime;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getHandleMsg() {
        return handleMsg;
    }

    public void setHandleMsg(String handleMsg) {
        this.handleMsg = handleMsg;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
