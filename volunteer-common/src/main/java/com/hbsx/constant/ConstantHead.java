package com.hbsx.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author sunhm
 * @email sunhm@hopshine.net
 * @date 2019/10/19
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description
 */
@Component
public class ConstantHead {

    public static String HEAD_URL;

    @Value("${hzApi.HEAD_URL}")
    public void setHeadUrl(String HEAD_URL) {
        ConstantHead.HEAD_URL = HEAD_URL;
    }


    /**
     * 空间图片路径头部
     */
    public static String SPACE_IMG;

    @Value("${hzApi.SPACE_IMG}")
    public void setSpaceImg(String SPACE_IMG) {
        ConstantHead.SPACE_IMG = SPACE_IMG;
    }


    /**
     * appid
     */
    public static String APP_ID;

    @Value("${hzApi.APP_ID}")
    public void setAppId(String APP_ID) {
        ConstantHead.APP_ID = APP_ID;
    }


    /**
     * 密码
     */
    public static String SECRET;

    @Value("${hzApi.SECRET}")
    public void setSECRET(String SECRET) {
        ConstantHead.SECRET = SECRET;
    }


    /**
     * 图书馆编码
     */
    public static String LIBRARY_CODE;

    @Value("${hzApi.LIBRARY_CODE}")
    public void setLibraryCode(String LIBRARY_CODE) {
        ConstantHead.LIBRARY_CODE = LIBRARY_CODE;
    }

    /**
     * 图书馆映射编码
     */
    public static String LIBRARY_MESSAGE;

    @Value("${hzApi.LIBRARY_MESSAGE}")
    public void setLibraryMessage(String LIBRARY_MESSAGE) {
        ConstantHead.LIBRARY_MESSAGE = LIBRARY_MESSAGE;
    }


    /**
     * 文化馆编码
     */
    public static String CULTURAL_CODE;

    @Value("${hzApi.CULTURAL_CODE}")
    public void setCulturalCode(String CULTURAL_CODE) {
        ConstantHead.CULTURAL_CODE = CULTURAL_CODE;
    }

    /**
     * 文化馆映射编码
     */
    public static String CULTURAL_MESSAGE;

    @Value("${hzApi.CULTURAL_MESSAGE}")
    public void setCulturalMessage(String CULTURAL_MESSAGE) {
        ConstantHead.CULTURAL_MESSAGE = CULTURAL_MESSAGE;
    }
}
