package cn.aldd.vape.user.micro.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class EncyclopediaImageVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "主键id")
	private String id;
	@ApiModelProperty(value = "百科id")
	private String encyclopediaId;
	@ApiModelProperty(value = "存储路径")
	private String url;
	@ApiModelProperty(value = "图片类型（1-图片，2-动态图片，3-小视频）")
	private String type;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date createTime;

// setter and getter
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getEncyclopediaId(){
		return encyclopediaId;
	}
	
	public void setEncyclopediaId(String encyclopediaId){
		this.encyclopediaId = encyclopediaId;
	}
	public String getUrl(){
		return url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	public java.util.Date getCreateTime(){
		return createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	
}