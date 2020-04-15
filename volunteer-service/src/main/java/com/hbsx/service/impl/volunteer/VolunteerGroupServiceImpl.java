package com.hbsx.service.impl.volunteer;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hbsx.constant.Constant;
import com.hbsx.entity.handleinfo.HandleInfo;
import com.hbsx.entity.volunteer.HzVolunteerGroup;
import com.hbsx.enums.HandleStageEnum;
import com.hbsx.enums.HandleTypeEnum;
import com.hbsx.enums.ModuleTypeEnum;
import com.hbsx.mappers.volunteer.VolunteerGroupDao;
import com.hbsx.service.handleinfo.HandleInfoService;
import com.hbsx.service.volunteer.VolunteerGroupService;
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
public class VolunteerGroupServiceImpl extends ServiceImpl<VolunteerGroupDao, HzVolunteerGroup> implements VolunteerGroupService {
    @Autowired
    private HandleInfoService handleInfoService;
    /**
     * 志愿者团队
     */
    public final static String GROUP = "group";

    /**
     * 志愿者
     */
    public final static String INFO = "info";


    @Override
    public Boolean processVolunteerGroup(String s) {
        long startTime=System.currentTimeMillis();
        try{
            String day = DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -1), Constant.FORMAT_DAY);
            String month = day.substring(5, 7);
            String year = day.substring(0, 4);
            if(s!=null&& !"".equals(s)){
                month = s.substring(5, 7);
                year = s.substring(0, 4);
            }
            List<HzVolunteerGroup> groupyearList = baseMapper.processVolunteerGroup(Constant.YEAR,year,month,GROUP);
            List<HzVolunteerGroup> groupmonthList = baseMapper.processVolunteerGroup(Constant.MONTH,year,month,GROUP);
            List<HzVolunteerGroup> infoyearList = baseMapper.processVolunteerGroup(Constant.YEAR,year,month,INFO);
            List<HzVolunteerGroup> infomonthList = baseMapper.processVolunteerGroup(Constant.MONTH,year,month,INFO);
            for (HzVolunteerGroup hzVolunteerGroup:
            infoyearList) {
                for (HzVolunteerGroup hzVolunteerGroup1:
                        groupyearList) {
                   if (hzVolunteerGroup.getInstCode().equals(hzVolunteerGroup1.getInstCode())&&hzVolunteerGroup.getDiTime()==hzVolunteerGroup1.getDiTime()&&hzVolunteerGroup.getTjDate().equals(hzVolunteerGroup1.getTjDate())){
                       hzVolunteerGroup.setGroupNum(hzVolunteerGroup1.getGroupNum());
                       hzVolunteerGroup.setGroupTotalNum(hzVolunteerGroup1.getGroupTotalNum());
                       groupyearList.remove(hzVolunteerGroup1);
                       break;
                   }
                }
            }
            for (HzVolunteerGroup hzVolunteerGroup:
                    infomonthList) {
                for (HzVolunteerGroup hzVolunteerGroup1:
                        groupmonthList) {
                    if (hzVolunteerGroup.getInstCode().equals(hzVolunteerGroup1.getInstCode())&&hzVolunteerGroup.getDiTime()==hzVolunteerGroup1.getDiTime()&&hzVolunteerGroup.getTjDate().equals(hzVolunteerGroup1.getTjDate())){
                    hzVolunteerGroup.setGroupNum(hzVolunteerGroup1.getGroupNum());
                    hzVolunteerGroup.setGroupTotalNum(hzVolunteerGroup1.getGroupTotalNum());
                    groupmonthList.remove(hzVolunteerGroup1);
                    break;
                }
              }
            }
            List<HzVolunteerGroup> yearList = new ArrayList<>();
            List<HzVolunteerGroup> monthList = new ArrayList<>();
            yearList.addAll(infoyearList);
            yearList.addAll(groupyearList);
            monthList.addAll(infomonthList);
            monthList.addAll(groupmonthList);
            List<HzVolunteerGroup> allList = new ArrayList<>();
            allList.addAll(yearList);
            allList.addAll(monthList);
            if(allList != null && allList.size() > 0){
                List<String> dateList = allList.stream().map(c -> c.getTjDate()).collect(Collectors.toList());
                baseMapper.deleteVolunteerGroupByTjDate(dateList);
                this.insertBatch(allList);
            }
            HandleInfo handleInfo = new HandleInfo();
            handleInfo.setStartTime(new Date(startTime));
            handleInfo.setModuleType(ModuleTypeEnum.VOLUNTEER_GROUP.getCode());
            handleInfo.setHandleType(HandleTypeEnum.VOLUNTEER_GROUP.getMessage());
            handleInfo.setHandleStage(HandleStageEnum.HANDING.getCode());
            handleInfo.setHandleName(HandleTypeEnum.VOLUNTEER_GROUP.getMessage()+HandleStageEnum.HANDING.getMessage());
            handleInfo.setHandleTime(LocalDateTime.now());
            handleInfo.setIsSuccess(Constant.SUCCESS);
            handleInfoService.insert(handleInfo);
            return true;
        } catch (Exception e){
            log.info("异常信息：", e.getMessage());
            HandleInfo handleInfo = new HandleInfo();
            handleInfo.setStartTime(new Date(startTime));
            handleInfo.setModuleType(ModuleTypeEnum.VOLUNTEER_GROUP.getCode());
            handleInfo.setHandleType(HandleTypeEnum.VOLUNTEER_GROUP.getMessage());
            handleInfo.setHandleStage(HandleStageEnum.HANDING.getCode());
            handleInfo.setHandleName(HandleTypeEnum.VOLUNTEER_GROUP.getMessage()+HandleStageEnum.HANDING.getMessage());
            handleInfo.setHandleTime(LocalDateTime.now());
            handleInfo.setIsSuccess(Constant.FAIL);
            handleInfo.setHandleMsg(e.getCause().getMessage());
            handleInfoService.insert(handleInfo);
            return false;
        }
    }

}
