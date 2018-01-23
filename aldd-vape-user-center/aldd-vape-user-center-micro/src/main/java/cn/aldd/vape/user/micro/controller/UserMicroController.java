package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.service.UserService;
import cn.aldd.vape.user.micro.vo.UserVo;

@RestController
public class UserMicroController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/user/micro/checkLogin")
	public Boolean checkLogin(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
		return userService.checkLogin(loginName, password);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/micro/{id}")
	public UserVo findUserById(@PathVariable("id") String id) {
		return userService.findUserById(id);
	}

}
