package cn.aldd.vape.user.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.user.micro.domain.EncyclopediaImage;
import cn.aldd.vape.user.micro.service.EncyclopediaImageService;
import cn.aldd.vape.user.micro.vo.EncyclopediaImageVo;

@RestController
public class EncyclopediaImageMicroController {
	@Autowired
	private EncyclopediaImageService encyclopediaImageService;

	@RequestMapping(method = RequestMethod.POST, value = "/encyclopediaImage/micro/addEncyclopediaImage")
	public EncyclopediaImage addEncyclopediaImage(@RequestBody EncyclopediaImage encyclopediaImage) {
		return encyclopediaImageService.addEncyclopediaImage(encyclopediaImage);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/encyclopediaImage/micro/updateEncyclopediaImage")
	public EncyclopediaImage updateEncyclopediaImage(@RequestBody EncyclopediaImage encyclopediaImage) {
		return encyclopediaImageService.updateEncyclopediaImage(encyclopediaImage);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/encyclopediaImage/micro/{id}")
	public EncyclopediaImageVo findEncyclopediaImageById(@PathVariable("id") String id) {
		return encyclopediaImageService.findEncyclopediaImageById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/encyclopediaImage/micro/findEncyclopediaImageList")
	public List<EncyclopediaImageVo> findEncyclopediaImageList(@RequestBody EncyclopediaImageVo encyclopediaImageVo) {
		return encyclopediaImageService.findEncyclopediaImageList(encyclopediaImageVo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/encyclopediaImage/micro/{id}")
	public void deleteEncyclopediaImageById(@PathVariable("id") String id) {
		encyclopediaImageService.deleteEncyclopediaImageById(id);
	}

}
