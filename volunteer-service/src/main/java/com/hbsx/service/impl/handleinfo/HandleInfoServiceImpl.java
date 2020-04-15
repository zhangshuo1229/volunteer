package com.hbsx.service.impl.handleinfo;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hbsx.entity.handleinfo.HandleInfo;
import com.hbsx.mappers.handleinfo.HandleInfoDao;
import com.hbsx.service.handleinfo.HandleInfoService;
import org.springframework.stereotype.Service;

/**
 * @author mazj
 * @email mazj@hopshine.net
 * @date 2019/11/27
 * @copyright ©2019 版权所属 华博胜讯信息科技股份有限公司
 * @description 采集日志实现层
 */
@Service
public class HandleInfoServiceImpl extends ServiceImpl<HandleInfoDao, HandleInfo> implements HandleInfoService {
}
