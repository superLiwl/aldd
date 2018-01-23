package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.User;
import cn.aldd.vape.user.micro.service.UserService;
import cn.aldd.vape.user.micro.vo.UserVo;

@RestController
public class UserMicroController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/user/micro/checkLogin/{loginName}/{password}")
	public Boolean checkLogin(@PathVariable("loginName") String loginName, @PathVariable("password") String password) {
		return userService.checkLogin(loginName, password);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/micro/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/micro/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	

	@RequestMapping(method = RequestMethod.GET, value = "/user/micro/{id}")
	public UserVo findUserById(@PathVariable("id") String id) {
		return userService.findUserById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user/micro/findUserList")
	public List<UserVo> findUserList(@RequestBody UserVo userVo) {
		return userService.findUserList(userVo);
	}

}
