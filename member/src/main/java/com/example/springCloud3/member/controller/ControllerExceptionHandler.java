package com.example.springCloud3.member.controller;

import cn.hutool.core.util.StrUtil;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(com.example.springCloud3.common.controller.ControllerExceptionHandler.class);

    /**
     * 所有异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e) throws Exception {
        LOG.info("seata全局事务ID: {}", RootContext.getXID());
        // 如果是在一次全局事务里出异常了，就不要包装返回值，将异常抛给调用方，让调用方回滚事务
        if (StrUtil.isNotBlank(RootContext.getXID())) {
            throw e;
        }
        Map<String, Object> map = new HashMap<>();

        LOG.error("系统异常：", e);
        map.put("error",e.getMessage());
        return map;
    }
}
