package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.Encyclopedia;
import cn.aldd.vape.user.micro.service.EncyclopediaService;
import cn.aldd.vape.user.micro.vo.EncyclopediaVo;

@RestController
public class EncyclopediaMicroController {
	@Autowired
	private EncyclopediaService encyclopediaService;

	@RequestMapping(method = RequestMethod.POST, value = "/encyclopedia/micro/addEncyclopedia")
	public Encyclopedia addEncyclopedia(@RequestBody Encyclopedia encyclopedia) {
		return encyclopediaService.addEncyclopedia(encyclopedia);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/encyclopedia/micro/updateEncyclopedia")
	public Encyclopedia updateEncyclopedia(@RequestBody Encyclopedia encyclopedia) {
		return encyclopediaService.updateEncyclopedia(encyclopedia);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/encyclopedia/micro/{id}")
	public EncyclopediaVo findEncyclopediaById(@PathVariable("id") String id) {
		return encyclopediaService.findEncyclopediaById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/encyclopedia/micro/findEncyclopediaList")
	public List<EncyclopediaVo> findEncyclopediaList(@RequestBody EncyclopediaVo encyclopediaVo) {
		return encyclopediaService.findEncyclopediaList(encyclopediaVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/encyclopedia/micro/{id}")
	public void deleteEncyclopediaById(@PathVariable("id") String id) {
		encyclopediaService.deleteEncyclopediaById(id);
	}

}
