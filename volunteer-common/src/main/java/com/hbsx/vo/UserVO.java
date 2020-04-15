package com.hbsx.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 测试vo类
 * @Author wangxiancheng
 * @Date 2019/5/8 10:13
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -3733325740467895475L;
    /**
     *  用户名
     */
    private String username;

}
