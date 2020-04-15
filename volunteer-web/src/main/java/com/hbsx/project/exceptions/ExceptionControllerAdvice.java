package com.hbsx.project.exceptions;


import com.hbsx.common.base.pub.ErrorCode;
import com.hbsx.common.base.pub.HbsxException;
import com.hbsx.common.base.pub.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * @Description 异常处理类
 * @Author wangxiancheng
 * @Date 2019/5/8 10:49
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice implements Serializable{


   /**
    *  异常封装
    * @Author wangxiancheng
    * @Date 2019/5/8 10:48
    * @return
    **/
    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleException(Exception ex){
        Result<Object> result = new Result<>();
        if (ex instanceof HbsxException){
            HbsxException wtcpException = (HbsxException)ex;
            result.setSuccess(false);
            result.setCode(wtcpException.getCode());
            result.setErrorMsg(wtcpException.getMessage());
            return result;
        }
        if(ex instanceof Throwable) {
            result.setCode(ErrorCode.SYSTEM_ERROR.getCode());
            result.setSuccess(false);
            result.setErrorMsg(ErrorCode.SYSTEM_ERROR.getMessage());
            return result;
        }
        return result;
    }


}
