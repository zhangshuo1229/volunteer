package com.hbsx.service.impl.volunteer;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hbsx.constant.Constant;
import com.hbsx.entity.handleinfo.HandleInfo;
import com.hbsx.entity.volunteer.HzVolunteerActivity;
import com.hbsx.enums.HandleStageEnum;
import com.hbsx.enums.HandleTypeEnum;
import com.hbsx.enums.ModuleTypeEnum;
import com.hbsx.mappers.volunteer.VolunteerActivityDao;
import com.hbsx.service.handleinfo.HandleInfoService;
import com.hbsx.service.volunteer.VolunteerActivityService;
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
@Service
@Slf4j
public class VolunteerActivityServiceImpl extends ServiceImpl<VolunteerActivityDao, HzVolunteerActivity> implements VolunteerActivityService {
    @Autowired
    private HandleInfoService handleInfoService;

    @Override
    public Boolean processActivity(String s) {
        long startTime=System.currentTimeMillis();
        try{
            String day = DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -1), Constant.FORMAT_DAY);
            String month = day.substring(5, 7);
            String year = day.substring(0, 4);
            if(s!=null&& !"".equals(s)){
                month = s.substring(5, 7);
                year = s.substring(0, 4);
            }
            List<HzVolunteerActivity> yearList = baseMapper.processVolunteerActivity(Constant.YEAR,year,month);
            List<HzVolunteerActivity> monthList = baseMapper.processVolunteerActivity(Constant.MONTH,year,month);
            List<HzVolunteerActivity> allList = new ArrayList<>();
            allList.addAll(yearList);
            allList.addAll(monthList);
            if(allList != null && allList.size() > 0){
                List<String> dateList = allList.stream().map(c -> c.getTjDate()).collect(Collectors.toList());
                baseMapper.deleteVolunteerActivityByTjDate(dateList);
                this.insertBatch(allList);
            }
            HandleInfo handleInfo = new HandleInfo();
            handleInfo.setStartTime(new Date(startTime));
            handleInfo.setModuleType(ModuleTypeEnum.VOLUNTEER_ACTIVITY.getCode());
            handleInfo.setHandleType(HandleTypeEnum.VOLUNTEER_ACTIVITY.getMessage());
            handleInfo.setHandleStage(HandleStageEnum.HANDING.getCode());
            handleInfo.setHandleName(HandleTypeEnum.VOLUNTEER_ACTIVITY.getMessage()+HandleStageEnum.HANDING.getMessage());
            handleInfo.setHandleTime(LocalDateTime.now());
            handleInfo.setIsSuccess(Constant.SUCCESS);
            handleInfoService.insert(handleInfo);
            return true;
        } catch (Exception e){
            log.info("异常信息：", e.getMessage());
            HandleInfo handleInfo = new HandleInfo();
            handleInfo.setStartTime(new Date(startTime));
            handleInfo.setModuleType(ModuleTypeEnum.VOLUNTEER_ACTIVITY.getCode());
            handleInfo.setHandleType(HandleTypeEnum.VOLUNTEER_ACTIVITY.getMessage());
            handleInfo.setHandleStage(HandleStageEnum.HANDING.getCode());
            handleInfo.setHandleName(HandleTypeEnum.VOLUNTEER_ACTIVITY.getMessage()+HandleStageEnum.HANDING.getMessage());
            handleInfo.setHandleTime(LocalDateTime.now());
            handleInfo.setIsSuccess(Constant.FAIL);
            handleInfo.setHandleMsg(e.getCause().getMessage());
            handleInfoService.insert(handleInfo);
            return false;
        }
    }
}
