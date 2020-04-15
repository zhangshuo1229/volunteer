package com.hbsx.enums;

/**
 * @author jiangyc
 * @email jiangyc@hopshine.net
 * @date 2019/7/15 0015
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description 加工业务分类枚举类
 */
public enum HandleTypeEnum {

    /**
     * 文化活动
     */
    ACTIVITY("activity", "文化活动"),
    MX_RES_VISIT("mx_resvisit", "资源访问明细"),
    /**
     * 艺术鉴赏
     */
    ART_APPRECIATION("artAppreciation", "艺术鉴赏"),
    /**
     * 展览展示
     */
    EXHIBITION("exhibition", "展览展示"),
    /**
     * 非遗传承
     */
    INTANGIBLE_HERITAGE("intangibleHeritage", "非遗传承"),
    /**
     * 直播录播视频
     */
    LIVE_VIDEO("liveVideo", "直播录播视频"),
    /**
     * 文化资讯
     */
    NEWS_NOTICE("newsNotice", "文化资讯"),
    /**
     * 师资
     */
    TEACHER("teacher", "师资"),
    /**
     * 课程
     */
    TEACHER_COURSE("teacherCourse", "课程"),
    /**
     * 小时人流量
     */
    VISITORS_HOUR("visitorsHour", "小时人流量"),
    /**
     * 周度人流量
     */
    VISITORS_WEEK("visitorsWeek", "周度人流量"),
    /**
     * 月度人流量
     */
    VISITORS_MONTH("visitorsMonth", "月度人流量"),
    /**
     * 明细人流量
     */
    VISITORS_MX("visitorsMonth", "明细人流量"),
    /**
     * 季度人流量
     */
    VISITORS_SEASON("visitorsSeason", "季度人流量"),
    /**
     * 年度人流量
     */
    VISITORS_YEAR("visitorsYear", "年度人流量"),

    /**
     * 日资源访问量
     */
    RES_VISIT_DAY("resvisit_day","日资源访问量"),
    /**
     * 月资源访问量
     */
    RES_VISIT_MONTH("resvisit_month","月资源访问量"),
    /**
     * 年资源访问量
     */
    RES_VISIT_YEAR("resvisit_year","年资源访问量"),
    /**
     * 书籍排行榜
     */
    TOP_BOOK_MONTH("topbookMonth","书柜月书籍排行榜"),
    /**
     * 书籍排行榜
     */
    TOP_BOOK_YEAR("topbookYear","书柜年书籍排行榜"),
    /**
     * 书籍排行榜
     */
    TOP_LIBBOOK_MONTH("toplibbookMonth","流通月书籍排行榜"),
    /**
     * 书籍排行榜
     */
    TOP_LIBBOOK_YEAR("toplibbookYear","流通年书籍排行榜"),
    /**
     * 作者排行榜
     */
    TOP_LIBAUTHOR_MONTH("toplibauthorMonth","流通月作者排行榜"),
    /**
     * 作者排行榜
     */
    TOP_LIBAUTHOR_YEAR("toplibauthorYear","流通年作者排行榜"),
    /**
     * 日书柜借还记录
     */
    BOOKCASE_BORROW_DAY("bookcaseborrowday","日书柜借还记录"),
    /**
     * 月书柜借还记录
     */
    BOOKCASE_BORROW_MONTH("bookcaseborrowmonth","月书柜借还记录"),

    /**
     * 年书柜借还记录
     */
    BOOKCASE_BORROW_YEAR("bookcaseborrowyear","年书柜借还记录"),
    /**
     * 作者排行榜
     */
    TOP_AUTHOR_MONTH("topauthorMonth","书柜月作者排行榜"),
    /**
     * 作者排行榜
     */
    TOP_AUTHOR_YEAR("topauthorYear","书柜年作者排行榜"),
    /**
     * 流通日
     */
    BORROW_DAY("borrowDay","流通日"),
    /**
     * 流通月
     */
    BORROW_MONTH("borrowMonth","流通月"),
    /**
     * 流通年
     */
    BORROW_YEAR("borrowYear","流通年"),
    /**
     * 办证读者日
     */
    READER_DAY("readerDay","办证读者日"),
    /**
     * 办证读者月
     */
    READER_MONTH("readerMonth","办证读者月"),
    /**
     * 办证读者年
     */
    READER_YEAR("readerYear","办证读者年"),
    /**
     * 办证读者性别分布日
     */
    READER_SEX_DAY("readerSexDay","办证读者性别分布日"),
    /**
     * 办证读者性别分布月
     */
    READER_SEX_MONTH("readerSexMonth","办证读者性别分布月"),
    /**
     * 办证读者性别分布年
     */
    READER_SEX_YEAR("readerSexYear","办证读者性别分布年"),
    /**
     * 办证读者年龄分布日
     */
    READER_AGE_DAY("readerAgeDay","办证读者年龄分布日"),
    /**
     * 办证读者年龄分布月
     */
    READER_AGE_MONTH("readerAgeMonth","办证读者年龄分布月"),
    /**
     * 办证读者年龄分布年
     */
    READER_AGE_YEAR("readerAgeYear","办证读者年龄分布年"),
    /**
     * 办证读者有效分布日
     */
    READER_VALID_DAY("readerValidDay","办证读者有效分布日"),
    /**
     * 办证读者有效分布月
     */
    READER_VALID_MONTH("readerValidMonth","办证读者有效分布月"),
    /**
     * 办证读者有效分布年
     */
    READER_VALID_YEAR("readerValidYear","办证读者有效分布年"),
    /**
     * 新增馆藏日
     */
    BOOKSTORE_DAY("bookstoreDay","新增馆藏日"),
    /**
     * 新增馆藏月
     */
    BOOKSTORE_MONTH("bookstoreMonth","新增馆藏月"),
    /**
     * 新增馆藏年
     */
    BOOKSTORE_YEAR("bookstoreYear","新增馆藏年"),
    /**
     * 新增馆藏形式分布日
     */
    BOOKSTORE_FORM_DAY("bookstoreFormDay","新增馆藏形式分布日"),
    /**
     * 新增馆藏形式分布月
     */
    BOOKSTORE_FORM_MONTH("bookstoreFormMonth","新增馆藏形式分布月"),
    /**
     * 新增馆藏形式分布年
     */
    BOOKSTORE_FORM_YEAR("bookstoreFormYear","新增馆藏形式分布年"),
    /**
     * 新增馆藏形式分布日
     */
    BOOKSTORE_ACQUIRE_METHOD_DAY("bookstoreAcquireMethodDay","新增馆藏来源分布日"),
    /**
     * 新增馆藏形式分布月
     */
    BOOKSTORE_ACQUIRE_METHOD_MONTH("bookstoreAcquireMethodMonth","新增馆藏来源分布月"),
    /**
     * 新增馆藏形式分布年
     */
    BOOKSTORE_ACQUIRE_METHOD_YEAR("bookstoreAcquireMethodYear","新增馆藏来源分布年"),
    /**
     * 新增馆藏形式分布日
     */
    BOOKSTORE_CARRIER_TYPE_DAY("bookstoreCarrierTypeDay","新增馆藏载体形式分布日"),
    /**
     * 新增馆藏形式分布月
     */
    BOOKSTORE_CARRIER_TYPE_MONTH("bookstoreCarrierTypeMonth","新增馆藏载体形式分布月"),
    /**
     * 新增馆藏形式分布年
     */
    BOOKSTORE_CARRIER_TYPE_YEAR("bookstoreCarrierTypeYear","新增馆藏形载体式分布年"),
    /**
     * 新增馆藏状态分布日
     */
    BOOKSTORE_STATUS_DAY("bookstoreStatusDay","新增馆藏状态分布日"),
    /**
     * 新增馆藏状态分布月
     */
    BOOKSTORE_STATUS_MONTH("bookstoreStatusMonth","新增馆藏状态分布月"),
    /**
     * 新增馆藏状态分布年
     */
    BOOKSTORE_STATUS_YEAR("bookstoreStatusYear","新增馆藏状态分布年"),
    /**
     * 新增馆藏日
     */
    BOOKSTORE_CLASSIFY_DAY("bookstoreClassifyDay","新增馆藏分类分布日"),
    /**
     * 新增馆藏月
     */
    BOOKSTORE_CLASSIFY_MONTH("bookstoreClassifyMonth","新增馆藏分类分布月"),
    /**
     * 新增馆藏年
     */
    BOOKSTORE_CLASSIFY_YEAR("bookstoreClassifyYear","新增馆藏分类分布年"),
    /**
     * 图书分类日流通
     */
    BOOKTYPE_DAY("booktypeDay","图书分类日流通"),
    /**
     * 图书分类月流通
     */
    BOOKTYPE_MONTH("booktypeMonth","图书分类月流通"),
    /**
     * 图书分类年流通
     */
    BOOKTYPE_YEAR("booktypeYear","图书分类年流通"),
    /**
     * 图书分类日流通
     */
    BORROWMETHOD_DAY("borrowMethodDay","流通方式日流通"),
    /**
     * 图书分类月流通
     */
    BORROWMETHOD_MONTH("borrowMethodMonth","流通方式月流通"),
    /**
     * 图书分类年流通
     */
    BORROWMETHOD_YEAR("borrowMethodYear","流通方式年流通"),
    /**
     * 图书分类日流通
     */
    BORROWORGSHAPE_DAY("borrowOrgshapeDay","流通形式日流通"),
    /**
     * 图书分类月流通
     */
    BORROWORGSHAPE_MONTH("borrowOrgshapeMonth","流通形式月流通"),
    /**
     * 图书分类年流通
     */
    BORROWORGSHAPE_YEAR("borrowOrgshapeYear","流通形式年流通"),
    /**
     * 志愿者
     */
    VOLUNTEER("volunteer", "志愿者"),
    /**
     * 志愿者团队
     */
    VOLUNTEER_GROUP("volunteerGroup", "志愿者团队"),
    /**
     * 志愿者活动
     */
    VOLUNTEER_ACTIVITY("volunteerActivity", "志愿者活动"),
    /**
     * 空间日预约
     */
    SPACE_APPOINTMENT("spaceAppointment", "空间日预约"),
    /**
     * 空间月预约
     */
    SPACE_MONTH_APPOINTMENT("spaceMonthAppointment", "空间月预约"),
    /**
     * 空间年预约
     */
    SPACE_YEAR_APPOINTMENT("spaceYearAppointment", "空间年预约"),
    /**
     * 座位日预约
     */
    SEAT_APPOINTMENT("seatAppointment", "座位日预约"),
    /**
     * 座位月预约
     */
    SEAT_MONTH_APPOINTMENT("seatMonthAppointment", "座位月预约"),
    /**
     * 座位年预约
     */
    SEAT_YEAR_APPOINTMENT("seatYearAppointment", "座位年预约"),
    QN_PERCENT_MONTH("qnpercentMonth","月调查问卷百分比汇总"),
    QN_PERCENT_YER("qnpercentYear","年调查问卷百分比汇总"),
    /**
     * 志愿者注册数据
     */
    RES_VOLUNTEER("resVolunteer", "志愿者注册数据"),
    /**
     * 志愿者团队注册数据
     */
    RES_VOLUNTEER_GROUP("resVolunteerGroup", "志愿者团队注册数据"),
    /**
     * 志愿者活动数据
     */
    RES_VOLUNTEER_ACTIVITY("resVolunteerActivity", "志愿者活动数据"),
    /**
     * 座位配置数据
     */
    SEAT_CONFIG("seatConfig", "座位配置数据"),
    /**
     * 座位预约数据
     */
    SEAT_RECORD("seatRecord", "座位预约数据"),
    /**
     * 空间配置数据
     */
    SPACE_CONFIG("spaceConfig", "空间配置数据"),
    /**
     * 空间数据
     */
    SPACE("space", "空间数据"),
    /**
     * 空间订单数据
     */
    SPACE_RECORD("spaceRecord", "空间订单数据"),


    MX_BOOKCASE_BORROW("mxbookcaseborrow", "书柜明细数据获取"),

    QN_QUESTION_MONTH("qnQuestionMonth", "调查问卷月汇总数据"),

    QN_QUESTION_YEAR("qnQuestionYear", "调查问卷年汇总数据");

    /**
     * 编码
     */
    private String code;

    /**
     * 内容
     */
    private String message;

    HandleTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
