package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.DynamicReward;
import cn.aldd.vape.user.micro.service.DynamicRewardService;
import cn.aldd.vape.user.micro.vo.DynamicRewardVo;

@RestController
public class DynamicRewardMicroController {
	@Autowired
	private DynamicRewardService dynamicRewardService;

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicReward/micro/addDynamicReward")
	public DynamicReward addDynamicReward(@RequestBody DynamicReward dynamicReward) {
		return dynamicRewardService.addDynamicReward(dynamicReward);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicReward/micro/updateDynamicReward")
	public DynamicReward updateDynamicReward(@RequestBody DynamicReward dynamicReward) {
		return dynamicRewardService.updateDynamicReward(dynamicReward);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dynamicReward/micro/{id}")
	public DynamicRewardVo findDynamicRewardById(@PathVariable("id") String id) {
		return dynamicRewardService.findDynamicRewardById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicReward/micro/findDynamicRewardList")
	public List<DynamicRewardVo> findDynamicRewardList(@RequestBody DynamicRewardVo dynamicRewardVo) {
		return dynamicRewardService.findDynamicRewardList(dynamicRewardVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/dynamicReward/micro/{id}")
	public void deleteDynamicRewardById(@PathVariable("id") String id) {
		dynamicRewardService.deleteDynamicRewardById(id);
	}

}
