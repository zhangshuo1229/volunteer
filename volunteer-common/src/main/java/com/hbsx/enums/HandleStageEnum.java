package com.hbsx.enums;

/**
 * @author jiangyc
 * @email jiangyc@hopshine.net
 * @date 2019/7/15 0015
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description 加工阶段序号枚举类
 */
public enum HandleStageEnum {

    /**
     * 采集
     */
    COLLECT("1", "采集获取明细数据"),
    /**
     * 加工
     */
    HANDING("2", "加工获取汇总数据"),

    /**
     * 加工
     */
    REHANDING("3", "二次加工获取汇总数据");

    /**
     * 编码
     */
    private String code;

    /**
     * 内容
     */
    private String message;

    HandleStageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
