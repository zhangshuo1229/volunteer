package com.hbsx.project.web;

import com.alibaba.fastjson.JSONObject;
import com.hbsx.common.base.enums.MessageTypeEnum;
import com.hbsx.common.base.mq.HbKafkaProducerServer;
import com.hbsx.common.base.pub.MessageDTO;
import com.hbsx.common.base.pub.Result;
import com.hbsx.entity.Demo;
import com.hbsx.service.TestService;
import com.hbsx.ucenter.SysUserServiceApi;
import com.hbsx.ucenter.UserService;
import com.hbsx.ucenter.utils.IDGeneratorHelpServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 测试用户controller
 * @Author wangxiancheng
 * @Date 2019/5/8 11:11
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Slf4j
@RestController
public class DemoController {

    @Value("${server.port}")
    private Integer port;
    @Resource
    private UserService userService;
    @Resource
    private SysUserServiceApi sysUserServiceApi;
    @Autowired
    private IDGeneratorHelpServer idGeneratorHelpServer;
    @Value("${kafka.topic}")
    private String kafkaTopic;
    @Autowired
    private HbKafkaProducerServer hbKafkaProducerServer;
    @Autowired
    private TestService testService;


    /**
     * 调用用户中心服务
     * @Author wangxiancheng
     * @Date 2019/9/29 16:21
     * @param
     * @return
     **/
    @GetMapping("/getUser/{id}")
    public Result getUser(@PathVariable("id") Long id) {
        log.info("userController---->{}", port);
        return userService.getUser(id);
    }

    /**
     * 消息发送到MQ
     * @Author wangxiancheng
     * @Date 2019/9/29 16:21
     * @param
     * @return
     **/
    @GetMapping("/getToken")
    public Result getToken() {
        Map map = new HashMap<>(1);
        map.put("name", "张三");
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessageTypeEnum(MessageTypeEnum.EMAIL_TYPE);
        messageDTO.setData(map);
        hbKafkaProducerServer.productMessage(kafkaTopic, "1", JSONObject.toJSONString(messageDTO));
        return null;
    }

    /**
     *  测试分布式事务
     * @Author wangxiancheng
     * @Date 2019/9/11 17:56
     * @param
     * @return
     **/
    @GetMapping("/testDistributeTx")
    public void testDistributeTx(){
        Demo demo = new Demo();
        demo.setId(idGeneratorHelpServer.generatorID());
        demo.setUsername("苏三");
        testService.testDistributeTx(demo);
    }



}