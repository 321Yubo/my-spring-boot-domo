package com.leon.demo.controller;

import com.leon.demo.DTO.Result;
import com.leon.demo.entity.SysUser;
import com.leon.demo.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Result test(Integer id) {
        Map map = new HashMap();
        map.put("1111","qqqq");
        map.put("222","wwww");

        return     ResultUtil.success(map);
    }
}
