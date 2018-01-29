package cn.aldd.vape.user.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import cn.aldd.vape.user.micro.domain.EncyclopediaComment;
import cn.aldd.vape.user.micro.service.EncyclopediaCommentService;
import cn.aldd.vape.user.micro.vo.EncyclopediaCommentVo;

@RestController
@RequestMapping(value = "/encyclopediaComment/micro")
public class EncyclopediaCommentMicroController {
	@Autowired
	private EncyclopediaCommentService encyclopediaCommentService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage addEncyclopediaComment(@RequestBody EncyclopediaComment encyclopediaComment) {
		return DataMessage.createSuccessMsg(encyclopediaCommentService.addEncyclopediaComment(encyclopediaComment), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage updateEncyclopediaComment(@RequestBody EncyclopediaComment encyclopediaComment) {
		return DataMessage.createSuccessMsg(encyclopediaCommentService.updateEncyclopediaComment(encyclopediaComment), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage findEncyclopediaCommentById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(encyclopediaCommentService.findEncyclopediaCommentById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage findEncyclopediaCommentList(@RequestBody EncyclopediaCommentVo encyclopediaCommentVo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(encyclopediaCommentService.findEncyclopediaCommentList(encyclopediaCommentVo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage deleteEncyclopediaCommentById(@PathVariable("id") String id) {
		encyclopediaCommentService.deleteEncyclopediaCommentById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
