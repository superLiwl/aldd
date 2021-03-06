package cn.aldd.vape.user.micro.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class EncyclopediaVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键id")
	private String id;
	@ApiModelProperty(value = "标题")
	private String title;
	@ApiModelProperty(value = "作者")
	private String author;
	@ApiModelProperty(value = "内容")
	private String content;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date createTime;
	@ApiModelProperty(value = "图片")
	private List<EncyclopediaImageVo> images;
	@ApiModelProperty(value = "关键字")
	private String keyWord;

	// setter and getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public List<EncyclopediaImageVo> getImages() {
		return images;
	}

	public void setImages(List<EncyclopediaImageVo> images) {
		this.images = images;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

}