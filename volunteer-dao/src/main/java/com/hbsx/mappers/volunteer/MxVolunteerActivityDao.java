package com.hbsx.mappers.volunteer;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hbsx.entity.volunteer.VolunteerActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/28 19:41
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：
 */
public interface MxVolunteerActivityDao extends BaseMapper<VolunteerActivity> {
    Boolean deleteVolunteerActivityByactivityId(@Param("dateList") List<String> dateList);
}
