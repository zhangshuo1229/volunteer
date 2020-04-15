package com.hbsx.mappers.volunteer;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hbsx.entity.volunteer.HzVolunteer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/28 19:41
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：
 */
public interface VolunteerDao extends BaseMapper<HzVolunteer> {
    List<HzVolunteer> processVolunteerAge(@Param("dateType") String dateType, @Param("year") String year,
                                          @Param("month") String month);
    List<HzVolunteer> processVolunteerSex(@Param("dateType") String dateType, @Param("year") String year,
                                          @Param("month") String month);
    List<HzVolunteer> processVolunteerEducation(@Param("dateType") String dateType, @Param("year") String year,
                                                @Param("month") String month);
    List<HzVolunteer> processVolunteerOccupation(@Param("dateType") String dateType, @Param("year") String year,
                                                 @Param("month") String month);

    Boolean deleteVolunteerByTjDate(@Param("dateList") List<String> dateList);
}
