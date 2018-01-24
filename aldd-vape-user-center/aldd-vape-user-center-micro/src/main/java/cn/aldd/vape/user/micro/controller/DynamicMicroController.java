package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.Dynamic;
import cn.aldd.vape.user.micro.service.DynamicService;
import cn.aldd.vape.user.micro.vo.DynamicVo;

@RestController
public class DynamicMicroController {
	@Autowired
	private DynamicService dynamicService;

	@RequestMapping(method = RequestMethod.POST, value = "/dynamic/micro/addDynamic")
	public Dynamic addDynamic(@RequestBody Dynamic dynamic) {
		return dynamicService.addDynamic(dynamic);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamic/micro/updateDynamic")
	public Dynamic updateDynamic(@RequestBody Dynamic dynamic) {
		return dynamicService.updateDynamic(dynamic);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dynamic/micro/{id}")
	public DynamicVo findDynamicById(@PathVariable("id") String id) {
		return dynamicService.findDynamicById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamic/micro/findDynamicList")
	public List<DynamicVo> findDynamicList(@RequestBody DynamicVo dynamicVo) {
		return dynamicService.findDynamicList(dynamicVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/dynamic/micro/{id}")
	public void deleteDynamicById(@PathVariable("id") String id) {
		dynamicService.deleteDynamicById(id);
	}

}
