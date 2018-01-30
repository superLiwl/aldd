package cn.aldd.vape.user.micro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aldd.vape.user.micro.constants.DynamicTypeEnum;
import cn.aldd.vape.user.micro.domain.Dynamic;
import cn.aldd.vape.user.micro.domain.DynamicImage;
import cn.aldd.vape.user.micro.repository.jpa.DynamicRepository;
import cn.aldd.vape.user.micro.repository.mybatis.dao.DynamicDao;
import cn.aldd.vape.user.micro.service.DynamicImageService;
import cn.aldd.vape.user.micro.service.DynamicService;
import cn.aldd.vape.user.micro.vo.DynamicFabulousVo;
import cn.aldd.vape.user.micro.vo.DynamicInfosVo;
import cn.aldd.vape.user.micro.vo.DynamicRewardVo;
import cn.aldd.vape.user.micro.vo.DynamicVo;
import cn.aldd.vape.util.Utils;

@Service("dynamicService")
public class DynamicServiceImpl implements DynamicService {

	@Autowired
	private DynamicDao dynamicDao;
	@Autowired
	private DynamicRepository dynamicRepository;
	@Autowired
	private DynamicImageService imageService;

	@Override
	public Dynamic addDynamic(Dynamic dynamic) {
		dynamic.setCreateTime(new Date());
		dynamic = dynamicRepository.save(dynamic);
		// 增加动态图片
		DynamicImage dynamicImage;
		if (!Utils.isNullList(dynamic.getImages())) {
			for (String url : dynamic.getImages()) {
				if (StringUtils.isNotBlank(url)) {
					dynamicImage = new DynamicImage();
					dynamicImage.setDynamicId(dynamic.getId());
					dynamicImage.setUrl(url);
					dynamicImage.setType(dynamic.getType());
					imageService.addDynamicImage(dynamicImage);
				}
			}
		}

		return dynamic;
	}

	@Override
	public DynamicVo findDynamicById(String id) {
		DynamicVo result = dynamicDao.findDynamicById(id);
		this.getDynamicInfos(result);
		return result;
	}

	@Override
	public PageInfo<DynamicVo> findDynamicList(DynamicVo dynamicVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<DynamicVo> result = new PageInfo<DynamicVo>(dynamicDao.findDynamicList(dynamicVo));
		if (pageNum > result.getPages()) {
			result.setList(null);
			result.setSize(0);
			result.setPageNum(pageNum);
		}
		if (!Utils.isNullList(result.getList())) {
			for (DynamicVo dy : result.getList()) {
				this.getDynamicInfos(dy);
			}
		}

		return result;
	}

	private void getDynamicInfos(DynamicVo dy) {
		List<DynamicInfosVo> infoList;
		List<DynamicFabulousVo> fabulous = new ArrayList<>();
		List<DynamicRewardVo> rewards = new ArrayList<>();
		DynamicFabulousVo fabulou;
		DynamicRewardVo reward;
		/**
		 * 查询评论 查询点赞 查询打赏
		 */
		infoList = dynamicDao.findDynamicInfosById(dy.getId());
		if (!Utils.isNullList(infoList)) {
			for (DynamicInfosVo info : infoList) {
				System.out.println(info.getType() + "-------" + info.getBusinessId());
				if (DynamicTypeEnum.FABULOUS.getKey().equals(info.getType())) {
					fabulou = new DynamicFabulousVo();
					fabulou.setId(info.getBusinessId());
					fabulou.setDynamicId(info.getDynamicId());
					fabulou.setCreateUserId(info.getCreateUserId());
					fabulou.setCreateTime(info.getCreateTime());
					fabulou.setNickName(info.getNickName());
					fabulous.add(fabulou);
				} else if (DynamicTypeEnum.COMMENT.getKey().equals(info.getType())) {

				} else if (DynamicTypeEnum.REWARD.getKey().equals(info.getType())) {
					reward = new DynamicRewardVo();
					reward.setId(info.getBusinessId());
					reward.setDynamicId(info.getDynamicId());
					reward.setCreateUserId(info.getCreateUserId());
					reward.setNickName(info.getNickName());
					reward.setCreateTime(info.getCreateTime());
					reward.setRewardNum(info.getBusinessData());
					rewards.add(reward);
				}
			}
			dy.setRewards(rewards);
			dy.setFabulous(fabulous);
		}
	}

	@Override
	public void deleteDynamicById(String id) {
		dynamicRepository.delete(id);
	}

}