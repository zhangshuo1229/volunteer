package com.hbsx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author wangxiancheng
 * @Date 2019/5/8 9:50
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -3767579727351134766L;

    /**
     *  用户id
     */
    private Long id;

    /**
     *  用户名称
     */
    private String username;
}
