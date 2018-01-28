package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.EncyclopediaComment;
import cn.aldd.vape.user.micro.service.EncyclopediaCommentService;
import cn.aldd.vape.user.micro.vo.EncyclopediaCommentVo;

@RestController
public class EncyclopediaCommentMicroController {
	@Autowired
	private EncyclopediaCommentService encyclopediaCommentService;

	@RequestMapping(method = RequestMethod.POST, value = "/encyclopediaComment/micro/addEncyclopediaComment")
	public EncyclopediaComment addEncyclopediaComment(@RequestBody EncyclopediaComment encyclopediaComment) {
		return encyclopediaCommentService.addEncyclopediaComment(encyclopediaComment);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/encyclopediaComment/micro/updateEncyclopediaComment")
	public EncyclopediaComment updateEncyclopediaComment(@RequestBody EncyclopediaComment encyclopediaComment) {
		return encyclopediaCommentService.updateEncyclopediaComment(encyclopediaComment);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/encyclopediaComment/micro/{id}")
	public EncyclopediaCommentVo findEncyclopediaCommentById(@PathVariable("id") String id) {
		return encyclopediaCommentService.findEncyclopediaCommentById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/encyclopediaComment/micro/findEncyclopediaCommentList")
	public List<EncyclopediaCommentVo> findEncyclopediaCommentList(@RequestBody EncyclopediaCommentVo encyclopediaCommentVo) {
		return encyclopediaCommentService.findEncyclopediaCommentList(encyclopediaCommentVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/encyclopediaComment/micro/{id}")
	public void deleteEncyclopediaCommentById(@PathVariable("id") String id) {
		encyclopediaCommentService.deleteEncyclopediaCommentById(id);
	}

}
