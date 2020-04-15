package com.hbsx.constant;

/**
 * @author sunhm
 * @email sunhm@hopshine.net
 * @date 2019/10/19
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description
 */
public class Constant {
    /**
     * 数据来源为接口接入
     */
    public final static String SOURCE_ZERO = "0";
    /**
     * 数据来源为后台输入
     */
    public final static String SOURCE_ONE = "1";
    /**
     * 数据来源为明细统计
     */
    public final static String SOURCE_TWO = "2";

    /**
     * 应用ID
     */
    public final static String HB_APP_ID = "hbAppId";

    /**
     * 密钥
     */
    public final static String APP_SECRET = "appSecret";

    /**
     * 时间戳
     */
    public final static String TIMESTAMP = "timestamp";

    /**
     * appid
     */
    public static String APP_ID = ConstantHead.APP_ID;

    /**
     * 密码
     */
    public static String SECRET = ConstantHead.SECRET;


    /**
     * 外部活动地址
     */
    public static String EXTERNAL_ACTIVITY =  ConstantHead.HEAD_URL+"api-web/web/activity/open-api/assessmentData";

    /**
     * 外部资讯地址
     */
    public static String EXTERNAL_NEWSNOTICE =  ConstantHead.HEAD_URL+"api-web/web/newNotice/open-api/data";

    /**
     * 外部非遗地址
     */
    public static String EXTERNAL_HERITAGE = ConstantHead.HEAD_URL+"api-web/web/inheritance/open-api/data";

    /**
     * 外部展览地址
     */
    public static String EXTERNAL_EXHIBITION =  ConstantHead.HEAD_URL+"api-web/web/artExhibition/open-api/data";

    /**
     * 外部师资地址
     */
    public static String EXTERNAL_TEACHER =  ConstantHead.HEAD_URL+"api-web/web/teacher/open-api/data";

    /**
     * 外部课程地址
     */
    public static String EXTERNAL_COURSE =  ConstantHead.HEAD_URL+"api-web/web/course/open-api/data";

    /**
     * 外部直播地址
     */
    public static String EXTERNAL_LIVE =  ConstantHead.HEAD_URL+"api-web/web/liveBroadcast/open-api/data";

    /**
     * 外部志愿者地址
     */
    public static String VOLUNTEER =  ConstantHead.HEAD_URL+"api-volunteer/volunteer/efficiency/open-api/getVolunteerList";

    /**
     * 外部志愿者团队地址
     */
    public static String VOLUNTEER_GROUP =  ConstantHead.HEAD_URL+"api-volunteer/volunteer/efficiency/open-api/getVolunteerGroupList";

    /**
     * 外部志愿者活动地址
     */
    public static String VOLUNTEER_ACTIVITY =  ConstantHead.HEAD_URL+"api-volunteer/volunteer/efficiency/open-api/getVolunteerActivityList";

    /**
     * 外部座位预约地址
     */
    public static String SEAT_RECORD =  ConstantHead.HEAD_URL+"api-reserve/reserve/external/seat/open-api/getSeatAppointList";

    /**
     * 外部座位配置地址
     */
    public static String SEAT_CONFIG =  ConstantHead.HEAD_URL+"api-reserve/reserve/external/seat/open-api/getSpaceSeatAppointList";

    /**
     * 外部空间信息地址
     */
    public static String SPACE =  ConstantHead.HEAD_URL+"api-reserve/reserve/external/space/open-api/dataList";

    /**
     * 外部空间订单地址
     */
    public static String SPACE_RECORD =  ConstantHead.HEAD_URL+"api-reserve/reserve/external/space/open-api/getSpaceAppointList";

    /**
     * 外部场次预约类型空间配置地址
     */
    public static String SPACE_SECOND_CONFIG =  ConstantHead.HEAD_URL+"api-reserve/reserve/external/space/open-api/getSpaceSceneList";

    /**
     * 外部时长预约类型空间配置地址
     */
    public static String SPACE_DATE_CONFIG =  ConstantHead.HEAD_URL+"api-reserve/reserve/external/space/open-api/getSpaceReserveTimeList";

    /**
     * 书柜接口code
     */
    public final static String BOOKCASE_CODE= "lib327615753589280315";
    /**
     * 资源接口code
     */
    public final static String RES_CODE= "28";

    /**
     * 数据有效
     */
    public final static String IS_VALID = "1";

    /**
     * 数据无效
     */
    public final static String NOT_VALID = "0";
    /**
     * 成功状态码200
     */
    public final static String CODE = "200";
    /**
     * 时间格式月
     */
    public final static String FORMAT_MONTH = "yyyy-MM";
    /**
     * 时间格式小时
     */
    public final static String FORMAT_HOUR= "yyyy-MM-dd HH:00:00";
    /**
     * 时间格式年
     */
    public final static String FORMAT_YEAR = "yyyy";
    /**
     * 时间格式周
     */
    public final static String FORMAT_WEEK = "yyyy w";
    /**
     * 时间格式日
     */
    public final static String FORMAT_DAY = "yyyy-MM-dd";
    /**
     * 时间格式时
     */
    public final static String FORMAT_TIME = "yyyy-MM-dd'T'HH:mm:ssXXX";

    /**
     * 时间格式
     */
    public final static String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 小时
     */
    public final static String HOUR = "hour";

    /**
     * 年
     */
    public final static String YEAR = "year";

    /**
     * 月
     */
    public final static String MONTH = "month";

    /**
     * 季
     */
    public final static String SEASON = "season";

    /**
     * 周
     */
    public final static String WEEK = "week";
    /**
     * 日
     */
    public final static String DAY = "day";

    /**
     * 文化活动加工默认加工前3个数据（包含当前月）
     */
    public static final Integer PROCESS_MONTH = 2;

    /**
     * 定时任务执行成功
     */
    public static final String SUCCESS = "1";

    /**
     * 定时任务执行失败
     */
    public static final String FAIL = "0";
}
