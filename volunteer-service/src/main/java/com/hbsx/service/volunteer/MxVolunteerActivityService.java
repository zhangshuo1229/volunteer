package com.hbsx.service.volunteer;


import com.baomidou.mybatisplus.service.IService;
import com.hbsx.entity.volunteer.VolunteerActivity;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/28 19:37
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：
 */
public interface MxVolunteerActivityService extends IService<VolunteerActivity> {
    Boolean getVolunteerActivitys(String str);
}
