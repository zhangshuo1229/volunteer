package com.hbsx.mappers.volunteer;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hbsx.entity.volunteer.HzVolunteerActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/28 19:41
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：
 */
public interface VolunteerActivityDao extends BaseMapper<HzVolunteerActivity> {
    List<HzVolunteerActivity> processVolunteerActivity(@Param("dateType") String dateType, @Param("year") String year,
                                                       @Param("month") String month);

    Boolean deleteVolunteerActivityByTjDate(@Param("dateList") List<String> dateList);
}
