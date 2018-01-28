package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.DynamicFabulous;
import cn.aldd.vape.user.micro.service.DynamicFabulousService;
import cn.aldd.vape.user.micro.vo.DynamicFabulousVo;

@RestController
public class DynamicFabulousMicroController {
	@Autowired
	private DynamicFabulousService dynamicFabulousService;

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicFabulous/micro/addDynamicFabulous")
	public DynamicFabulous addDynamicFabulous(@RequestBody DynamicFabulous dynamicFabulous) {
		return dynamicFabulousService.addDynamicFabulous(dynamicFabulous);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicFabulous/micro/updateDynamicFabulous")
	public DynamicFabulous updateDynamicFabulous(@RequestBody DynamicFabulous dynamicFabulous) {
		return dynamicFabulousService.updateDynamicFabulous(dynamicFabulous);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dynamicFabulous/micro/{id}")
	public DynamicFabulousVo findDynamicFabulousById(@PathVariable("id") String id) {
		return dynamicFabulousService.findDynamicFabulousById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicFabulous/micro/findDynamicFabulousList")
	public List<DynamicFabulousVo> findDynamicFabulousList(@RequestBody DynamicFabulousVo dynamicFabulousVo) {
		return dynamicFabulousService.findDynamicFabulousList(dynamicFabulousVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/dynamicFabulous/micro/{id}")
	public void deleteDynamicFabulousById(@PathVariable("id") String id) {
		dynamicFabulousService.deleteDynamicFabulousById(id);
	}

}
