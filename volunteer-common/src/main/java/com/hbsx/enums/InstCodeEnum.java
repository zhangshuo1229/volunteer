package com.hbsx.enums;


import com.hbsx.constant.ConstantHead;

/**
 * @author jiangyc
 * @email jiangyc@hopshine.net
 * @date 2019/7/15 0015
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description 包河场馆编码枚举类
 */
public enum InstCodeEnum {

    /**
     * 图书馆(包河图书馆 )
     */
    LIBRARY(ConstantHead.LIBRARY_CODE,ConstantHead.LIBRARY_MESSAGE),
    /**
     * 文化馆(群文云)
     */
    CULTURAL(ConstantHead.CULTURAL_CODE, ConstantHead.CULTURAL_MESSAGE);

    /**
     * 编码
     */
    private String code;

    /**
     * 内容
     */
    private String message;

    InstCodeEnum(String code, String message) {
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
