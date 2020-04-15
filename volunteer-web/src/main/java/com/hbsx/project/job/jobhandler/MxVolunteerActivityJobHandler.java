package com.hbsx.project.job.jobhandler;

import com.hbsx.service.volunteer.MxVolunteerActivityService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author zhangs
 * @email zhangs@hopshine.net
 * @date 2019/11/01
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description 定时任务工作类
 */
@Slf4j
@JobHandler(value = "mxVolunteerActivity")
@Component
public class MxVolunteerActivityJobHandler extends IJobHandler {

    @Autowired
    private MxVolunteerActivityService volunteerService;


    @Override
    public ReturnT<String> execute(String s) throws Exception {

       if(volunteerService.getVolunteerActivitys(s)){
            return SUCCESS;
        }else{
           return FAIL;
       }
    }
}
