package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.UserFollow;
import cn.aldd.vape.user.micro.service.UserFollowService;
import cn.aldd.vape.user.micro.vo.UserFollowVo;

@RestController
public class UserFollowMicroController {
	@Autowired
	private UserFollowService userFollowService;

	@RequestMapping(method = RequestMethod.POST, value = "/userFollow/micro/addUserFollow")
	public UserFollow addUserFollow(@RequestBody UserFollow userFollow) {
		return userFollowService.addUserFollow(userFollow);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/userFollow/micro/updateUserFollow")
	public UserFollow updateUserFollow(@RequestBody UserFollow userFollow) {
		return userFollowService.updateUserFollow(userFollow);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/userFollow/micro/{id}")
	public UserFollowVo findUserFollowById(@PathVariable("id") String id) {
		return userFollowService.findUserFollowById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/userFollow/micro/findUserFollowList")
	public List<UserFollowVo> findUserFollowList(@RequestBody UserFollowVo userFollowVo) {
		return userFollowService.findUserFollowList(userFollowVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/userFollow/micro/{id}")
	public void deleteUserFollowById(@PathVariable("id") String id) {
		userFollowService.deleteUserFollowById(id);
	}

}
