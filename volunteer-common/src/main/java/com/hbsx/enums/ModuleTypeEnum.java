package com.hbsx.enums;

/**
 * @author mazj
 * @email mazj@hopshine.net
 * @date 2019/11/22 0015
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description 模块类型枚举类
 */
public enum ModuleTypeEnum {

    /**
     * 活动
     */
    ACTIVITY("1", "活动"),

    /**
     * 资讯
     */
    NEWS("2", "资讯"),
    /**
     * 非遗
     */
    HERITAGE("3", "非遗"),
    /**
     *  艺术鉴赏
     */
    ART_APPRECIATION("4", "艺术鉴赏"),
    /**
     *  展览展示
     */
    EXHIBITION("5", "展览展示"),
    /**
     *  师资群艺
     */
    TEACHER("6", "师资群艺"),
    /**
     *  课程
     */
    COURSE("7", "课程"),
    /**
     *  直播录播视频
     */
    LIVE_VIDEO("8", "直播录播视频"),

    /**
     * 到馆
     */
    VISITORS("9", "到馆"),
    /**
     * 读者
     */
    READER("10", "读者"),
    /**
     * 馆藏
     */
    BOOKSTORE("11", "馆藏"),
    /**
     * 流通
     */
    BORROW("12", "流通"),
    /**
     * 资源访问
     */
    RES_VISIT("13", "资源访问"),
    /**
     * 书柜借还
     */
    BOOKCASE_BORROW("14", "书柜借还"),
    /**
     * 志愿者
     */
    VOLUNTEER("15", "志愿者"),
    /**
     * 志愿者
     */
    VOLUNTEER_GROUP("16", "志愿者团队"),
    /**
     * 志愿者活动
     */
    VOLUNTEER_ACTIVITY("17", "志愿者活动"),
    /**
     * 空间
     */
    SPACE("18", "空间"),
    /**
     * 座位
     */
    SEAT("19", "座位"),
    /**
     * 调查问卷
     */
    QUESTION("20", "调查问卷");

    /**
     * 编码
     */
    private String code;

    /**
     * 内容
     */
    private String message;

    ModuleTypeEnum(String code, String message) {
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
