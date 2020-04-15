package com.hbsx.service.impl.volunteer;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hbsx.constant.Constant;
import com.hbsx.entity.handleinfo.HandleInfo;
import com.hbsx.entity.volunteer.HzVolunteer;
import com.hbsx.enums.HandleStageEnum;
import com.hbsx.enums.HandleTypeEnum;
import com.hbsx.enums.ModuleTypeEnum;
import com.hbsx.mappers.volunteer.VolunteerDao;
import com.hbsx.service.handleinfo.HandleInfoService;
import com.hbsx.service.volunteer.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：zhangshuo
 * @date ： 2019/11/28 19:39
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description：
 */
@Slf4j
@Service
public class VolunteerServiceImpl extends ServiceImpl<VolunteerDao, HzVolunteer> implements VolunteerService {
    @Autowired
    private HandleInfoService handleInfoService;
    private static String ALL = "all";

    @Override
    public Boolean processVolunteer(String s) {
        long startTime=System.currentTimeMillis();
        try{
            String day = DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -1), Constant.FORMAT_DAY);
            String month = day.substring(5, 7);
            String year = day.substring(0, 4);
            if(s!=null&& !"".equals(s)){
                month = s.substring(5, 7);
                year = s.substring(0, 4);
            }
            List<HzVolunteer> ageYearList = baseMapper.processVolunteerAge(Constant.YEAR,year,month);
            List<HzVolunteer> ageMonthList = baseMapper.processVolunteerAge(Constant.MONTH,year,month);
            List<HzVolunteer> ageAllList = baseMapper.processVolunteerAge(ALL,year,month);

            List<HzVolunteer> sexYearList = baseMapper.processVolunteerSex(Constant.YEAR,year,month);
            List<HzVolunteer> sexMonthList = baseMapper.processVolunteerSex(Constant.MONTH,year,month);
            List<HzVolunteer> sexAllList = baseMapper.processVolunteerSex(ALL,year,month);

            List<HzVolunteer> occupationYearList = baseMapper.processVolunteerOccupation(Constant.YEAR,year,month);
            List<HzVolunteer> occupationMonthList = baseMapper.processVolunteerOccupation(Constant.MONTH,year,month);
            List<HzVolunteer> occupationAllList = baseMapper.processVolunteerOccupation(ALL,year,month);

            List<HzVolunteer> educationYearList = baseMapper.processVolunteerEducation(Constant.YEAR,year,month);
            List<HzVolunteer> educationMonthList = baseMapper.processVolunteerEducation(Constant.MONTH,year,month);
            List<HzVolunteer> educationAllList = baseMapper.processVolunteerEducation(ALL,year,month);
            List<HzVolunteer> allList = new ArrayList<>();
            allList.addAll(ageYearList);
            allList.addAll(ageMonthList);
            allList.addAll(ageAllList);
            allList.addAll(sexYearList);
            allList.addAll(sexMonthList);
            allList.addAll(sexAllList);
            allList.addAll(occupationYearList);
            allList.addAll(occupationMonthList);
            allList.addAll(occupationAllList);
            allList.addAll(educationYearList);
            allList.addAll(educationMonthList);
            allList.addAll(educationAllList);

            if(allList != null && allList.size() > 0){
                List<String> dateList = allList.stream().map(c -> c.getTjDate()).collect(Collectors.toList());
                baseMapper.deleteVolunteerByTjDate(dateList);
                this.insertBatch(allList);
            }
            HandleInfo handleInfo = new HandleInfo();
            handleInfo.setStartTime(new Date(startTime));
            handleInfo.setModuleType(ModuleTypeEnum.VOLUNTEER.getCode());
            handleInfo.setHandleType(HandleTypeEnum.VOLUNTEER.getMessage());
            handleInfo.setHandleStage(HandleStageEnum.HANDING.getCode());
            handleInfo.setHandleName(HandleTypeEnum.VOLUNTEER.getMessage()+HandleStageEnum.HANDING.getMessage());
            handleInfo.setHandleTime(LocalDateTime.now());
            handleInfo.setIsSuccess(Constant.SUCCESS);
            handleInfoService.insert(handleInfo);
            return true;
        } catch (Exception e){
            log.info("异常信息：", e.getMessage());
            HandleInfo handleInfo = new HandleInfo();
            handleInfo.setStartTime(new Date(startTime));
            handleInfo.setModuleType(ModuleTypeEnum.VOLUNTEER.getCode());
            handleInfo.setHandleType(HandleTypeEnum.VOLUNTEER.getMessage());
            handleInfo.setHandleStage(HandleStageEnum.HANDING.getCode());
            handleInfo.setHandleName(HandleTypeEnum.VOLUNTEER.getMessage()+HandleStageEnum.HANDING.getMessage());
            handleInfo.setHandleTime(LocalDateTime.now());
            handleInfo.setIsSuccess(Constant.FAIL);
            handleInfo.setHandleMsg(e.getCause().getMessage());
            handleInfoService.insert(handleInfo);
            return false;
        }
    }
}
