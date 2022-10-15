package com.leon.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leon.demo.DTO.Result;
import com.leon.demo.entity.SysUser;
import com.leon.demo.service.UserService;
import com.leon.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getone", method = RequestMethod.GET)
	public String userPage(Integer id) {
		SysUser user = userService.getById(id);
		return "/user/list";
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public Result<List<SysUser>> getAll() {
		List<SysUser> userList = userService.getAll();
		return ResultUtil.success(userList);
	}

	@RequestMapping(value = "/test_get_writer", method = RequestMethod.GET)
	// @ResponseBody
	public void testGetWriter(HttpServletResponse response) throws IOException {
//		List<SysUser> userList = userService.getAll();
//		return ResultUtil.success(userList);
		response.getWriter().write("Hello world");
		return;
	}
}
