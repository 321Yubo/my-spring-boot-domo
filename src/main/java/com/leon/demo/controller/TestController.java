package com.leon.demo.controller;

import com.alibaba.fastjson.JSON;
import com.leon.demo.DTO.Result;
import com.leon.demo.entity.SysUser;
import com.leon.demo.entity.Test;
import com.leon.demo.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping(value = "/test", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result test(Test test) {
        log.info("接受参数{}", JSON.toJSONString(test));
        Map map = new HashMap();
        map.put("1111","qqqq");
        map.put("222","wwww");
        return     ResultUtil.success(map);
    }
}
