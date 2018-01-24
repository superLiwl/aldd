package cn.aldd.vape.user.micro.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.aldd.vape.common.Page;
import io.swagger.annotations.ApiModelProperty;

public class DynamicVo extends Page {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "主键id")
	private String id;
	@ApiModelProperty(value = "创建人")
	private String userId;
	@ApiModelProperty(value = "动态内容")
	private String content;
	@ApiModelProperty(value = "发表地址")
	private String address;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date createTime;
	@ApiModelProperty(value = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date updateTime;

// setter and getter
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getUserId(){
		return userId;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public java.util.Date getCreateTime(){
		return createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	
}