package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.DynamicComment;
import cn.aldd.vape.user.micro.service.DynamicCommentService;
import cn.aldd.vape.user.micro.vo.DynamicCommentVo;

@RestController
public class DynamicCommentMicroController {
	@Autowired
	private DynamicCommentService dynamicCommentService;

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicComment/micro/addDynamicComment")
	public DynamicComment addDynamicComment(@RequestBody DynamicComment dynamicComment) {
		return dynamicCommentService.addDynamicComment(dynamicComment);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicComment/micro/updateDynamicComment")
	public DynamicComment updateDynamicComment(@RequestBody DynamicComment dynamicComment) {
		return dynamicCommentService.updateDynamicComment(dynamicComment);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dynamicComment/micro/{id}")
	public DynamicCommentVo findDynamicCommentById(@PathVariable("id") String id) {
		return dynamicCommentService.findDynamicCommentById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dynamicComment/micro/findDynamicCommentList")
	public List<DynamicCommentVo> findDynamicCommentList(@RequestBody DynamicCommentVo dynamicCommentVo) {
		return dynamicCommentService.findDynamicCommentList(dynamicCommentVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/dynamicComment/micro/{id}")
	public void deleteDynamicCommentById(@PathVariable("id") String id) {
		dynamicCommentService.deleteDynamicCommentById(id);
	}

}
