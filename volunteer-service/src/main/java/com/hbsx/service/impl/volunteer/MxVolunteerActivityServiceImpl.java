package com.hbsx.service.impl.volunteer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hbsx.constant.Constant;
import com.hbsx.entity.handleinfo.HandleInfo;
import com.hbsx.entity.volunteer.VolunteerActivity;
import com.hbsx.enums.HandleStageEnum;
import com.hbsx.enums.HandleTypeEnum;
import com.hbsx.enums.InstCodeEnum;
import com.hbsx.enums.ModuleTypeEnum;
import com.hbsx.mappers.volunteer.MxVolunteerActivityDao;
import com.hbsx.service.handleinfo.HandleInfoService;
import com.hbsx.service.volunteer.MxVolunteerActivityService;
import com.hbsx.utils.HttpSendtUtil;
import com.hopshine.common.exception.RRException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class MxVolunteerActivityServiceImpl extends ServiceImpl<MxVolunteerActivityDao, VolunteerActivity> implements MxVolunteerActivityService {
    @Autowired
    private HandleInfoService handleInfoService;

    @Override
    @Transactional(rollbackFor = RRException.class)
    public Boolean getVolunteerActivitys(String str) {
        long startTime=System.currentTimeMillis();
        try {
            List venueNums = new ArrayList();
            for (InstCodeEnum instCodeEnum : InstCodeEnum.values()) {
                venueNums.add(instCodeEnum.getCode());
            }
            JSONObject libJson = HttpSendtUtil.getJsonDateStr(venueNums, Constant.VOLUNTEER_ACTIVITY,null,str);
            HandleInfo handleInfo = new HandleInfo();
            handleInfo.setStartTime(new Date(startTime));
            handleInfo.setModuleType(ModuleTypeEnum.VOLUNTEER_ACTIVITY.getCode());
            handleInfo.setHandleType(HandleTypeEnum.RES_VOLUNTEER_ACTIVITY.getMessage());
            handleInfo.setHandleStage(HandleStageEnum.COLLECT.getCode());
            handleInfo.setHandleName(HandleTypeEnum.RES_VOLUNTEER_ACTIVITY.getMessage()+HandleStageEnum.COLLECT.getMessage());
            handleInfo.setHandleTime(LocalDateTime.now());
            if(libJson != null){
                if(libJson.getInteger("code") == 200){
                    List<VolunteerActivity> libraryList = getList(libJson);
                    if(libraryList != null && libraryList.size()>0){
                        List<String> volunteerIds = libraryList.stream().map(e -> e.getActivityId()).collect(Collectors.toList());
                        baseMapper.deleteVolunteerActivityByactivityId(volunteerIds);
                        this.insertBatch(libraryList);
                    }
                    handleInfo.setIsSuccess(Constant.SUCCESS);
                    handleInfoService.insert(handleInfo);
                    return true;
                } else{
                    handleInfo.setIsSuccess(Constant.FAIL);
                    handleInfo.setHandleMsg(libJson.getString("errorMsg"));
                    handleInfoService.insert(handleInfo);
                    return false;
                }
            }else{
                handleInfo.setIsSuccess(Constant.FAIL);
                handleInfo.setHandleMsg("网络异常！");
                handleInfoService.insert(handleInfo);
                return false;
            }
        }catch (Exception e){
            log.info("异常信息：", e.getMessage());
            HandleInfo handleInfo = new HandleInfo();
            handleInfo.setStartTime(new Date(startTime));
            handleInfo.setModuleType(ModuleTypeEnum.VOLUNTEER_ACTIVITY.getCode());
            handleInfo.setHandleType(HandleTypeEnum.RES_VOLUNTEER_ACTIVITY.getMessage());
            handleInfo.setHandleStage(HandleStageEnum.COLLECT.getCode());
            handleInfo.setHandleName(HandleTypeEnum.RES_VOLUNTEER_ACTIVITY.getMessage()+HandleStageEnum.COLLECT.getMessage());
            handleInfo.setHandleTime(LocalDateTime.now());
            handleInfo.setIsSuccess(Constant.FAIL);
            handleInfo.setHandleMsg(e.getCause().getMessage());
            handleInfoService.insert(handleInfo);
            e.printStackTrace();
            return false;
        }
    }

    private List<VolunteerActivity> getList(JSONObject jsonStr){
        try{
            JSONArray jsonArray = jsonStr.getJSONArray("data");
            List<VolunteerActivity> list = new ArrayList<>(jsonArray.size());
            for(int i=0;i<jsonArray.size();i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                String venueNum = obj.getString("venueNum");
                if (StringUtils.isNotBlank(venueNum)){
                    VolunteerActivity volunteer = new VolunteerActivity();
                    volunteer.setAct_end_date(obj.getDate("actEndDate"));
                    volunteer.setAct_img(obj.getString("coverImgPath"));
                    volunteer.setAct_start_date(obj.getDate("actStartDate"));
                    volunteer.setAct_type(obj.getString("actTypeName"));
                    volunteer.setActivityId(obj.getString("activityId"));
                    volunteer.setActName(obj.getString("actName"));
                    volunteer.setAddress(obj.getString("address"));
                    volunteer.setContent(obj.getString("content"));
                    volunteer.setParticipantNum(obj.getInteger("registeredNum"));
                    for(InstCodeEnum instCodeEnum : InstCodeEnum.values()){
                        if(instCodeEnum.getCode().equals(venueNum)){
                            volunteer.setInstCode(instCodeEnum.getMessage().split(":")[1]);
                            volunteer.setInstName(instCodeEnum.getMessage().split(":")[0]);
                        }
                    }
                    if (StringUtils.isNotBlank(volunteer.getInstCode())){
                        list.add(volunteer);
                    }
                }
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
