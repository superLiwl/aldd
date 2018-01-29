package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.DynamicComment;
import cn.aldd.vape.user.micro.service.DynamicCommentService;
import cn.aldd.vape.user.micro.vo.DynamicCommentVo;

@RestController
@RequestMapping(value = "/dynamicComment/micro")
public class DynamicCommentMicroController {
	@Autowired
	private DynamicCommentService dynamicCommentService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addDynamicComment(@RequestBody DynamicComment dynamicComment) {
		return DataMessage.createSuccessMsg(dynamicCommentService.addDynamicComment(dynamicComment), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateDynamicComment(@RequestBody DynamicComment dynamicComment) {
		return DataMessage.createSuccessMsg(dynamicCommentService.updateDynamicComment(dynamicComment), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findDynamicCommentById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(dynamicCommentService.findDynamicCommentById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findDynamicCommentList(@RequestBody DynamicCommentVo dynamicCommentVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(dynamicCommentService.findDynamicCommentList(dynamicCommentVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteDynamicCommentById(@PathVariable("id") String id) {
		dynamicCommentService.deleteDynamicCommentById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
