package cn.aldd.vape.user.micro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dynamic_image")
public class DynamicImage implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(unique = true, nullable = false, length = 36, name = "id")
	private String id;
	/**
	 * 动态id
	 */
	@Column(nullable = false,length = 36, name = "dynamic_id")
	private String dynamicId;
	/**
	 * 存储路径
	 */
	@Column(nullable = false,length = 255, name = "url")
	private String url;
	/**
	 * 图片类型（1-图片，2-动态图片，3-小视频）
	 */
	@Column(nullable = false,length = 36, name = "type")
	private String type;
	/**
	 * 创建时间
	 */
	@Column(nullable = false, name = "create_time")
	private java.util.Date createTime;

// setter and getter
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getDynamicId(){
		return dynamicId;
	}
	
	public void setDynamicId(String dynamicId){
		this.dynamicId = dynamicId;
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
